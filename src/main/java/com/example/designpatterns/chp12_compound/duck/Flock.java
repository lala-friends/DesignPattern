package main.java.com.example.designpatterns.chp12_compound.duck;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {
    private List<Quackable> quackables;
    private final Observable observable;

    public Flock() {
        this.quackables = new ArrayList<>();
        this.observable = new Observable(this);
    }

    public void add(final Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void quack() {
        for (Quackable quacker : quackables) {
            quacker.quack();
            notifyObservers();
        }
    }

    @Override
    public void registerObserver(final Observer observer) {
        for (Quackable quacker : quackables) {
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
