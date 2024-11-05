package main.java.com.example.designpatterns.chp9_iterator_and_composite.iterator;

import java.util.Iterator;

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
