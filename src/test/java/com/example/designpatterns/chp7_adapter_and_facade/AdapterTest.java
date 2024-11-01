package test.java.com.example.designpatterns.chp7_adapter_and_facade;

import main.java.com.example.designpatterns.chp7_adapter_and_facade.adapter.EnumerationIterator;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.adapter.IteratorEnumeration;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.simple_adapter.DuckAdapter;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.simple_adapter.MallardDuck;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.simple_adapter.TurkeyAdapter;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.simple_adapter.WildTurkey;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Vector;

public class AdapterTest {
    @Test
    public void testTurkeyToDuck() {
        final var turkey = new WildTurkey();
        final var turkeyAdapter = new TurkeyAdapter(turkey);

        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }

    @Test
    void testDuckToTurkey() {
        final var duck = new MallardDuck();
        final var duckAdapter = new DuckAdapter(duck);

        duckAdapter.gobble();
        duckAdapter.fly();
    }

    @Test
    void testEnumerationToIterator() {
        final var list = Arrays.asList(1, 2, 3);
        final var vector = new Vector<>(list);
        final var iterator = new EnumerationIterator(vector.elements());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void testIteratorToEnumeration() {
        final var list = Arrays.asList(1, 2, 3);
        final var enumeration = new IteratorEnumeration(list.stream().iterator());
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
