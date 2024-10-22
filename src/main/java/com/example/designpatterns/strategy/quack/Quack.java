package main.java.com.example.designpatterns.strategy.quack;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("꿱");
    }
}
