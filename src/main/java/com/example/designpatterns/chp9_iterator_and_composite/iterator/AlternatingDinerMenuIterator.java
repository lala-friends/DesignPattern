package main.java.com.example.designpatterns.chp9_iterator_and_composite.iterator;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Objects;

public class AlternatingDinerMenuIterator implements Iterator {
    private final MenuItem[] menuItems;
    private int position;

    public AlternatingDinerMenuIterator(final MenuItem[] menuItems) {
        this.menuItems = Objects.requireNonNull(menuItems);
        position = Calendar.DAY_OF_WEEK % 2;
    }

    @Override
    public boolean hasNext() {
        return position < menuItems.length && menuItems[position] != null;
    }

    @Override
    public Object next() {
        final var menuItem = menuItems[position];
        position += 2;
        return menuItem;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove()는 지원하지 않습니다.");
    }
}
