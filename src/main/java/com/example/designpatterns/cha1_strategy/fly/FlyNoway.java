package main.java.com.example.designpatterns.cha1_strategy.fly;

public class FlyNoway implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("저는 못날아요.");
    }
}
