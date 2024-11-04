package main.java.com.example.designpatterns.chp9_iterator_and_composite;

import java.util.HashMap;

public class CafeMenu {
    private final HashMap<String, MenuItem> menuItems;

    public CafeMenu() {
        this.menuItems = new HashMap<>();

        addMenuItem("베지 버거와 에어 프라이", "통밀빵, 상추, 토마토, 감자튀김이 첨가된 베지 보거", true, 3.99);
        addMenuItem("오늘의 스프", "샐러드가 곁들여진 오늘의 스프", false, 3.69);
        addMenuItem("베리또", "통 핀토콩과 살사, 구아카몰이 곁들여진 푸짐한 베리또", true, 4.29);
    }

    public void addMenuItem(final String name, final String description, final boolean vegetarian, final double price) {
        final var menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(), menuItem);
    }

    public HashMap<String, MenuItem> getMenuItems() {
        return menuItems;
    }
}
