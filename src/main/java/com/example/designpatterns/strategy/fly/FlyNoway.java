package main.java.com.example.designpatterns.strategy.fly;

public class FlyNoway implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
