package main.java.com.example.designpatterns.strategy.duck;

import main.java.com.example.designpatterns.strategy.fly.FlyNoway;
import main.java.com.example.designpatterns.strategy.quack.MuteQuack;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        super(new FlyNoway(), new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("I'm a decoy duck");
    }
}
