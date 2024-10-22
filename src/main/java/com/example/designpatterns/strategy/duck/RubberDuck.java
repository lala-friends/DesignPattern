package main.java.com.example.designpatterns.strategy.duck;

import main.java.com.example.designpatterns.strategy.fly.FlyNoway;
import main.java.com.example.designpatterns.strategy.quack.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoway();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I'm a rubber duck");
    }
}
