package main.java.com.example.designpatterns.cha1_strategy.duck;

import main.java.com.example.designpatterns.cha1_strategy.fly.FlyNoway;
import main.java.com.example.designpatterns.cha1_strategy.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoway();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("저는 모형오리입니다.");
    }
}
