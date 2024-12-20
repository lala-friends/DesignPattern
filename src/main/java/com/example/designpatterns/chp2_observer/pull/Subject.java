package main.java.com.example.designpatterns.chp2_observer.pull;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
