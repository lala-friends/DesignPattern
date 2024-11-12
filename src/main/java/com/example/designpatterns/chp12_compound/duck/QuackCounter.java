package main.java.com.example.designpatterns.chp12_compound.duck;

import java.util.Objects;

public class QuackCounter implements Quackable {
    private static int numberOfQuacks;
    private final Quackable duck;
    private final Observable observable;

    public QuackCounter(final Quackable duck) {
        numberOfQuacks = 0;
        this.duck = Objects.requireNonNull(duck);
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks += 1;
        notifyObservers();
    }

    public static int getQuacks() {
        return numberOfQuacks;
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
        return duck.toString();
    }
}
