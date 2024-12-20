package main.java.com.example.designpatterns.chp9_iterator_and_composite.iterator;

import java.util.Iterator;
import java.util.Objects;

public class Waitress {
    private final Menu pancakeHouseMenu;
    private final Menu dinnerMenu;
    private final Menu cafeMenu;

    public Waitress(final Menu pancakeHouseMenu,
                    final Menu dinnerMenu,
                    final Menu cafeMenu) {
        this.pancakeHouseMenu = Objects.requireNonNull(pancakeHouseMenu);
        this.dinnerMenu = Objects.requireNonNull(dinnerMenu);
        this.cafeMenu = Objects.requireNonNull(cafeMenu);
    }

    public void printMenu() {
        final var pancakeIterator = pancakeHouseMenu.createIterator();
        final var dinnerIterator = dinnerMenu.createIterator();
        final var cafeIterator = cafeMenu.createIterator();

        System.out.println("아침 메뉴");
        printMenu(pancakeIterator);

        System.out.println("점심 메뉴");
        printMenu(dinnerIterator);

        System.out.println("저녁 메뉴");
        printMenu(cafeIterator);
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
