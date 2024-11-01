package test.java.com.example.designpatterns.chp7_adapter_and_facade;

import main.java.com.example.designpatterns.chp7_adapter_and_facade.DuckAdapter;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.MallardDuck;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.TurkeyAdapter;
import main.java.com.example.designpatterns.chp7_adapter_and_facade.WildTurkey;
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
