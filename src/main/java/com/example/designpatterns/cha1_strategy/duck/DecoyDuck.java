package main.java.com.example.designpatterns.cha1_strategy.duck;

import main.java.com.example.designpatterns.cha1_strategy.fly.FlyNoway;
import main.java.com.example.designpatterns.cha1_strategy.quack.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new FlyNoway();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("I'm a decoy duck");
    }
}
