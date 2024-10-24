package main.java.com.example.designpatterns.cha1_strategy.duck;

import main.java.com.example.designpatterns.cha1_strategy.fly.FlyWithWings;
import main.java.com.example.designpatterns.cha1_strategy.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a mallard duck");
    }
}
