package main.java.com.example.designpatterns.chp12_compound.duck;

public interface QuackObservable {
    void registerObserver(final Observer observer);

    void notifyObservers();
}
