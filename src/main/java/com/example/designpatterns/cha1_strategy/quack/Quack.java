package main.java.com.example.designpatterns.cha1_strategy.quack;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("꿱");
    }
}
