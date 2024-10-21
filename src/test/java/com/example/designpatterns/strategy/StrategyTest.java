package test.java.com.example.designpatterns.strategy;

import main.java.com.example.designpatterns.strategy.duck.DecoyDuck;
import main.java.com.example.designpatterns.strategy.duck.MallardDuck;
import main.java.com.example.designpatterns.strategy.duck.RedheadDuck;
import main.java.com.example.designpatterns.strategy.duck.RubberDuck;
import org.junit.jupiter.api.Test;

public class StrategyTest {
    @Test
    public void createMallardDuck() {
        final var duck = new MallardDuck();

        duck.performFly();
        duck.performQuack();
        duck.display();
        duck.swim();
    }

    @Test
    void createRedheadDuck() {
        final var duck = new RedheadDuck();

        duck.performFly();
        duck.performQuack();
        duck.display();
        duck.swim();
    }

    @Test
    void createRubberDuck() {
        final var duck = new RubberDuck();

        duck.performFly();
        duck.performQuack();
        duck.display();
        duck.swim();
    }

    @Test
    void createDecoyDuck() {
        final var duck = new DecoyDuck();

        duck.performFly();
        duck.performQuack();
        duck.display();
        duck.swim();
    }
}
