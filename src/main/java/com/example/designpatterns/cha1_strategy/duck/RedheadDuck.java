package main.java.com.example.designpatterns.cha1_strategy.duck;

import main.java.com.example.designpatterns.cha1_strategy.fly.FlyWithWings;
import main.java.com.example.designpatterns.cha1_strategy.quack.Quack;

public class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a redhead duck");
    }
}
