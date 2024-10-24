package main.java.com.example.designpatterns.chp2_observer.pull2;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private final List<Observer> observers;
    private float temperature;
    private float humidity;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        final var index = observers.indexOf(observer);

        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(final float temperature, final float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        measurementsChanged();
    }

    @Override
    public float getTemperature() {
        return temperature;
    }

    @Override
    public float getHumidity() {
        return humidity;
    }
}
