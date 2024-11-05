package main.java.com.example.designpatterns.chp9_iterator_and_composite.composite;

import java.util.Objects;

public class Waitress {
    private final MenuComponent allMenus;

    public Waitress(final MenuComponent allMenus) {
        this.allMenus = Objects.requireNonNull(allMenus);
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarianMenu() {
        final var iterator = allMenus.createIterator();

        System.out.println("\nVEGETARIAN MENU\n----------");

        while (iterator.hasNext()) {
            final var menuComponent = (MenuComponent) iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {
            }
        }
    }
}
