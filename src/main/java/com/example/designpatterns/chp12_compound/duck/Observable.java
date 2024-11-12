package main.java.com.example.designpatterns.chp12_compound.duck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Observable implements QuackObservable {
    private final List<Observer> observers = new ArrayList<>();
    private final QuackObservable duck;

    public Observable(final QuackObservable duck) {
        this.duck = Objects.requireNonNull(duck);
    }

    @Override
    public void registerObserver(final Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(duck);
        }
    }
}
