package main.java.com.example.designpatterns.chp9_iterator_and_composite;

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
