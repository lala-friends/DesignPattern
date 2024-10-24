package main.java.com.example.designpatterns.chp2_observer.push.observer;

import main.java.com.example.designpatterns.chp2_observer.push.subject.Subject;

public class CurrentConditionsDisplay implements Observer, Display {
    private final Subject subject;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(final Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(final float temperature, final float humidity, final float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;

        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
