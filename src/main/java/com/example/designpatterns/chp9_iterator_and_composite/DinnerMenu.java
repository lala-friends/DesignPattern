package main.java.com.example.designpatterns.chp9_iterator_and_composite;

import java.util.Iterator;

public class DinnerMenu implements Menu {
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
