package test.java.com.example.designpatterns.chp1_strategy;

import main.java.com.example.designpatterns.cha1_strategy.duck.*;
import main.java.com.example.designpatterns.cha1_strategy.fly.FlyRocketPowered;
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

    @Test
    void createModelDuck() {
        final var duck = new ModelDuck();

        duck.performFly();
        duck.setFlyBehavior(new FlyRocketPowered());
        duck.performFly();
    }
}
