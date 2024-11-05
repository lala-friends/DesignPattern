package test.java.com.example.designpatterns.chp9_iterator_and_composite;

import main.java.com.example.designpatterns.chp9_iterator_and_composite.iterator.CafeMenu;
import main.java.com.example.designpatterns.chp9_iterator_and_composite.iterator.DinnerMenu;
import main.java.com.example.designpatterns.chp9_iterator_and_composite.iterator.PancakeHouseMenu;
import main.java.com.example.designpatterns.chp9_iterator_and_composite.iterator.Waitress;
import org.junit.jupiter.api.Test;

public class IteratorTest {
    @Test
    public void testIterator() {
        final var pancakeHouseMenu = new PancakeHouseMenu();
        final var dinnerMenu = new DinnerMenu();
        final var cafeMenu = new CafeMenu();

        final var waitress = new Waitress(pancakeHouseMenu, dinnerMenu, cafeMenu);
        waitress.printMenu();
    }
}
