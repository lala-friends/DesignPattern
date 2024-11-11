package main.java.com.example.designpatterns.chp12_compound;

public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
