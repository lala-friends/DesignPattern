# 이터레이터와 컴포지트 패턴

* 학습목표
    * 이터레이터 패턴
        * 객체를 컬렉션에 집어 넣는 방법: 배열, 스택, 해시테이블 ...
        * 클라이언트에서 컬렉션 안에 있는 객체들에 접근하는 작업을 할 때, 객체럴 저장하는 방식을 보여주지 않으면서도 접근할 수 있게 하는 방법
    * 컴포지트 패턴
        * 한방에 자료 구조로 변신할 수 있는 객체들로 구성된 수퍼 컬렉션

## 객체 마을식당, 객체마을 팬케이크 하우스 합병

### 합의 본 메뉴 코드

```java
public class MenuItem {
    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final double price;

    public MenuItem(final String name,
                    final String description,
                    final boolean vegetarian,
                    final double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}
```

### 객체마을 팬케이크 하우스의 구현 - ArrayList 사용

```java
public class PancakeHouseMenu {
    private final List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("K&B 팬케이크 세트", "스크램블드 에그와 토스트가 곁들여진 팬케이크", true, 2.99);
        addItem("레귤러 팬케이크", "달걀 후리아와 소시지가 곁들여진 팬케이크", false, 2.99);
        addItem("블루베리 팬케이크", "신선한 블루베리와 블루베리 시럽으로 만든 팬케이크", true, 3.49);
        addItem("와플", "와플, 취향에 따라 블루베리나 딸기를 얹을 수 있습니다.", false, 3.59);
    }

    private void addItem(final String name,
                         final String description,
                         final boolean vagetarian,
                         final double price) {
        final var menuItem = new MenuItem(name, description, vagetarian, price);
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
```

### 객체마을 식당의 구현 - array 사용

```java
public class DinnerMenu {
    private static final int MAX_ITEMS = 6;
    private final MenuItem[] menuItems;
    private int numberOfItems = 0;

    public DinnerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("채식주의자용 BLT", "통밀 위에(식물성) 베이컨, 상추, 토파토를 얹은 메뉴", true, 2.99);
        addItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99);
        addItem("오늘의 스프", "감자 샐러드르 ㄹ곁들인 오늘의 스프", false, 3.29);
        addItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그", false, 3.05);
    }

    private void addItem(final String name,
                         final String description,
                         final boolean vagetarian,
                         final double price) {
        final var menuItem = new MenuItem(name, description, vagetarian, price);

        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("죄송합니다, 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없습니다.");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems += 1;
        }
    }
}
```

### 웨이트리스 구현

```java
import main.java.com.example.designpatterns.chp9_iterator_and_composite.DinnerMenu;
import main.java.com.example.designpatterns.chp9_iterator_and_composite.PancakeHouseMenu;

public void printMenu() {
    final var pancakeHouseMenu = new PancakeHouseMenu();
    final var breakfastItems = pancakeHouseMenu.getMenuItems();

    final var dinerMenu = new DinnerMenu();
    final var lunchItems = dinerMenu.getMenuItems();

    for (MenuItem breakfastItem : breakfastItems) {
        System.out.print(breakfastItem.getName() + "  ");
        System.out.println(breakfastItem.getPrice());
        System.out.println(breakfastItem.getDescription());
    }

    for (int i = 0; i < lunchItems.length; i++) {
        final var lunchItem = lunchItems[i];
        System.out.print(lunchItem.getName() + "  ");
        System.out.println(lunchItem.getPrice());
        System.out.println(lunchItem.getDescription());
    }
}
```

* 문제점
    * 구상 클래스에 맞춰서 코딩하고 있다.
    * DinnerMenu를 사용하는 방식에서 메뉴항목의 목록을 HashTable로 변경하려면 Waitress의 코드를 변경해야 한다.
    * Waitress 에서 메뉴항목의 컬렉션을 표현하는 방법을 알아야 한다.
        * 캡슐화 위반
    * 코드 종복

## 반복을 캡슐화

### 기존 코드

```java
// Waitress.java
public void printMenu() {
    // ArrayList의 size(), get() 사용
    for (int i = 0; i < breakfastItems.size(); i++) {
        MenuItem menuItem = (MenuItem) breakfastItems.get(i);
        // ...
    }

    // 배열의 length, 배열 첨자 이용
    for (int i = 0; i < lunchItems.lengh; i++) {
        MenuItem menuItem = lunchItems[i];
        // ...
    }
}
```

### 이터레이터 패턴 적용

* 반복작업 캡슐화

<p align="center"><img width="700" alt="fly" src="./images/1.png">

* Iterator 인터페이스 정의

```java
public interface Iterator {
    boolean hasNext();

    Object next();
}
```

* DinnerMenuIterator 구현

```java
public class DinnerMenuIterator implements Iterator {
    private final MenuItem[] menuItems;
    private int position = 0;

    public DinnerMenuIterator(final MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return menuItems != null && position < menuItems.length && menuItems[position] != null;
    }

    @Override
    public Object next() {
        final var menuItem = menuItems[position];
        position += 1;
        return menuItem;
    }
}
```

* DinerMenu 에 Iterator 추가

```java
public class DinnerMenu {
    private static final int MAX_ITEMS = 6;
    private final MenuItem[] menuItems;
    private int numberOfItems = 0;

    public DinnerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("채식주의자용 BLT", "통밀 위에(식물성) 베이컨, 상추, 토파토를 얹은 메뉴", true, 2.99);
        addItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99);
        addItem("오늘의 스프", "감자 샐러드르 ㄹ곁들인 오늘의 스프", false, 3.29);
        addItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그", false, 3.05);
    }

    private void addItem(final String name,
                         final String description,
                         final boolean vagetarian,
                         final double price) {
        final var menuItem = new MenuItem(name, description, vagetarian, price);

        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("죄송합니다, 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없습니다.");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems += 1;
        }
    }

    public Iterator createIterator() {
        return new DinnerMenuIterator(menuItems);
    }
}
```

* Waitress 코드 고치기
    - 메뉴구현법이 캡슐화 됨,
        - waitress 의 입장에서는 메뉴에서 메뉴 항목의 컬렉션을 어떤 식으로 저장하는지 알 수 없음
        - waitress 는 인터페이스(iterator)만 알고 있으면 됨
    - 여전히 구상 클래스(PancakeHouseMenu, DinerMenu)에 묶여 있음
        - TODO: 고처야 함

```java
public class Waitress {
    private final PancakeHouseMenu pancakeHouseMenu;
    private final DinnerMenu dinnerMenu;

    public Waitress(final PancakeHouseMenu pancakeHouseMenu,
                    final DinnerMenu dinnerMenu) {
        this.pancakeHouseMenu = Objects.requireNonNull(pancakeHouseMenu);
        this.dinnerMenu = Objects.requireNonNull(dinnerMenu);
    }

    public void printMenu() {
        final var pancakeIterator = pancakeHouseMenu.createIterator();
        final var dinnerIterator = dinnerMenu.createIterator();

        System.out.println("아침 메뉴");
        printMenu(pancakeIterator);

        System.out.println("점심 메뉴");
        printMenu(dinnerIterator);
    }

    private void printMenu(final Iterator iterator) {
        while (iterator.hasNext()) {
            final MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + ", -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}
```

* 테스트

```java

@Test
public void testIterator() {
    final var pancakeHouseMenu = new PancakeHouseMenu();
    final var dinnerMenu = new DinnerMenu();

    final var waitress = new Waitress(pancakeHouseMenu, dinnerMenu);
    waitress.printMenu();
}
```

* 결과

```text
아침 메뉴
K&B 팬케이크 세트, 2.99, -- 스크램블드 에그와 토스트가 곁들여진 팬케이크
레귤러 팬케이크, 2.99, -- 달걀 후리아와 소시지가 곁들여진 팬케이크
블루베리 팬케이크, 3.49, -- 신선한 블루베리와 블루베리 시럽으로 만든 팬케이크
와플, 3.59, -- 와플, 취향에 따라 블루베리나 딸기를 얹을 수 있습니다.
점심 메뉴
채식주의자용 BLT, 2.99, -- 통밀 위에(식물성) 베이컨, 상추, 토파토를 얹은 메뉴
BLT, 2.99, -- 통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴
오늘의 스프, 3.29, -- 감자 샐러드르 ㄹ곁들인 오늘의 스프
핫도그, 3.05, -- 사워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그
```

* 클래드 다이어그램

<p align="center"><img width="1000" alt="fly" src="./images/2.png">

### 인터페이스 개선

* 직접 작성한 Iterator를 java.util.Iterator로 변경
* 클래스 다이어그램

<p align="center"><img width="1000" alt="fly" src="./images/3.png">

* PancakeHouseMenuIterator 삭제
* DinerMenuIterator 수정

```java
public class DinnerMenuIterator implements Iterator {
    private final MenuItem[] menuItems;
    private int position = 0;

    public DinnerMenuIterator(final MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return menuItems != null && position < menuItems.length && menuItems[position] != null;
    }

    @Override
    public Object next() {
        final var menuItem = menuItems[position];
        position += 1;
        return menuItem;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("next()를 한번도 호출하지 않은 상태에서는 삭제할 수 없습니다.");
        }

        if (menuItems[position - 1] != null) {
            for (int i = position - 1; i < menuItems.length - 1; i++) {
                menuItems[i] = menuItems[i + 1];
            }
            menuItems[menuItems.length - 1] = null;
        }
    }
}
```

* Menu 인터페이스 추가

```java
public interface Menu {
    Iterator createIterator();
}
```

* PancakeHouseMenu, DinerMenu 수정
    * Iterator 를 java.util.Iterator 로 변경
    * Menu 를 구현하도록 변경
* Waitress 수정

```java
public class Waitress {
    private final Menu pancakeHouseMenu;
    private final Menu dinnerMenu;

    public Waitress(final Menu pancakeHouseMenu,
                    final Menu dinnerMenu) {
        this.pancakeHouseMenu = Objects.requireNonNull(pancakeHouseMenu);
        this.dinnerMenu = Objects.requireNonNull(dinnerMenu);
    }

    public void printMenu() {
        final var pancakeIterator = pancakeHouseMenu.createIterator();
        final var dinnerIterator = dinnerMenu.createIterator();

        System.out.println("아침 메뉴");
        printMenu(pancakeIterator);

        System.out.println("점심 메뉴");
        printMenu(dinnerIterator);
    }

    private void printMenu(final Iterator iterator) {
        while (iterator.hasNext()) {
            final MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + ", -- ");
            System.out.println(menuItem.getDescription());
        }
    }
}
```

## 이터레이터 패턴

> 컬렉션 구현 방법을 노출시키지 않으면서도
> 그 집합체 안에 들어있는 모든 항목에 접근할 수 있게 해 주는 방법을 제공

* 집합체 내에서 어떤식으로 일이 처리되는지에 대해서는 모르는 샅태에서 그 안에 모든 항목에 대한 반복작업을 처리
    * 캡슐화
* 모든 항목에 접근하는 작업을 컬렉션 객체가 아니라 반복자 객체에서 처리
    * 집합체의 인터페이스 및 구현이 간단해 짐

### 클래스 다이어그램

<p align="center"><img width="1000" alt="fly" src="./images/4.png">

### 이터레이터 패턴 관련 질문

* 내부반복자 vs 외부 반복자
    * 외부반복자: 클라이언트가 반복작업을 제어 - 클라이언트에서 next()를 호출하여 다음 항목을 가져옴
    * 내부반복자: 반복자 자신에 의해 제어 - 클라이언트가 작업을 넘겨 주어야 한다.
        * 유연성이 떨어짐
        * 외부에서 사용하기가 편리
* Enumeration 인터페이스
    * 예전에 Iterator 용도로 사용
    * hasNext() -> hasMoreElements()
    * next() -> nextElement()

## 객체지향 원칙 - 단일 역할 원칙

> 클래스를 바꾸는 이유는 한가지 뿐이어야 한다.

* 응집도: 한 클래스 또는 모듈이 특정 목적 또는 역할을 얼마나 일관되게 지원하는지를 나타내는 척도


