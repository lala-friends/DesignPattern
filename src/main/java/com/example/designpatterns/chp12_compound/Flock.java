package main.java.com.example.designpatterns.chp12_compound;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
    private List<Quackable> quackables;

    public Flock() {
        this.quackables = new ArrayList<>();
    }

    public void add(final Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void quack() {
        for (Quackable quacker : quackables) {
            quacker.quack();
        }
    }
}
