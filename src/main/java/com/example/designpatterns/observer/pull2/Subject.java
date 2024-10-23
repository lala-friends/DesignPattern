package main.java.com.example.designpatterns.observer.pull2;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    float getTemperature();

    float getHumidity();
}
