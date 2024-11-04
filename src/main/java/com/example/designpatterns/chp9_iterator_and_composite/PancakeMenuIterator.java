package main.java.com.example.designpatterns.chp9_iterator_and_composite;

import java.util.List;

public class PancakeMenuIterator implements Iterator {
    private final List<MenuItem> menuItems;
    private int position = 0;

    public PancakeMenuIterator(final List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {

        return menuItems != null && menuItems.size() > position;
    }

    @Override
    public Object next() {
        final var menuItem = menuItems.get(position);
        position += 1;
        return menuItem;
    }
}
