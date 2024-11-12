package main.java.com.example.designpatterns.chp12_compound.duck;

import java.util.Objects;

public class GooseAdapter implements Quackable {
    private final Goose goose;
    private final Observable observable;

    public GooseAdapter(final Goose goose) {
        this.goose = Objects.requireNonNull(goose);
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }

    @Override
    public void registerObserver(final Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public String toString() {
        return goose.toString();
    }
}
