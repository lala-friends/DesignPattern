package main.java.com.example.designpatterns.observer.push.subject;

import main.java.com.example.designpatterns.observer.push.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
