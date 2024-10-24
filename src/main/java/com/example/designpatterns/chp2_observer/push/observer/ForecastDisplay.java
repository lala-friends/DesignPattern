package main.java.com.example.designpatterns.chp2_observer.push.observer;

import main.java.com.example.designpatterns.chp2_observer.push.subject.Subject;

public class ForecastDisplay implements Observer, Display {
    private final Subject subject;
    private float lastPressure;
    private float currentPressure;

    public ForecastDisplay(final Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

    @Override
    public void update(final float temperature, final float humidity, final float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }
}
