package main.java.com.example.designpatterns.chp2_observer.push.observer;

import main.java.com.example.designpatterns.chp2_observer.push.subject.Subject;

public class HeatIndexDisplay implements Observer, Display {
    private final Subject subject;
    private float temperature;
    private float humidity;

    public HeatIndexDisplay(final Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void display() {
        float index = (float) ((16.923 + (0.185212 * temperature) + (5.37941 * humidity) - (0.100254 * temperature * humidity)
                + (0.00941695 * (temperature * temperature)) + (0.00728898 * (humidity * humidity))
                + (0.000345372 * (temperature * temperature * humidity)) - (0.000814971 * (temperature * humidity * humidity)) +
                (0.0000102102 * (temperature * temperature * humidity * humidity)) - (0.000038646 * (temperature * temperature * temperature)) + (0.0000291583 *
                (humidity * humidity * humidity)) + (0.00000142721 * (temperature * temperature * temperature * humidity)) +
                (0.000000197483 * (temperature * humidity * humidity * humidity)) - (0.0000000218429 * (temperature * temperature * temperature * humidity * humidity)) +
                0.000000000843296 * (temperature * temperature * humidity * humidity * humidity)) -
                (0.0000000000481975 * (temperature * temperature * temperature * humidity * humidity * humidity)));

        System.out.println("Heat index is " + index);
    }

    @Override
    public void update(final float temperature, final float humidity, final float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;

        display();
    }
}
