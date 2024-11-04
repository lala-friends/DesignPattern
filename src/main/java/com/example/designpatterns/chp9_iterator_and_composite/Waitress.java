package main.java.com.example.designpatterns.chp9_iterator_and_composite;

import java.util.Iterator;
import java.util.Objects;

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
