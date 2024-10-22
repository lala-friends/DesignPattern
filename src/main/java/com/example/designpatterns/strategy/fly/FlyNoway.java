package main.java.com.example.designpatterns.strategy.fly;

public class FlyNoway implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("저는 못날아요.");
    }
}
