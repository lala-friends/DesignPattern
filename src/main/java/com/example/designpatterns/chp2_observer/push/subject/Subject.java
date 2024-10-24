package main.java.com.example.designpatterns.chp2_observer.push.subject;

import main.java.com.example.designpatterns.chp2_observer.push.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
