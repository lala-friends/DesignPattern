package test.java.com.example.designpatterns.chp7_adapter_and_facade;

import main.java.com.example.designpatterns.chp7_adapter_and_facade.simple_adapter.DuckAdapter;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.simple_adapter.MallardDuck;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.simple_adapter.TurkeyAdapter;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.simple_adapter.WildTurkey;
import org.junit.jupiter.api.Test;

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
}
