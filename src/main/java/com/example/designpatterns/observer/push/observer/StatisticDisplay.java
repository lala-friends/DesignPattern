package main.java.com.example.designpatterns.observer.push.observer;

import main.java.com.example.designpatterns.observer.push.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class StatisticDisplay implements Observer, Display {
    private final Subject subject;
    private final List<Float> temperatures;

    public StatisticDisplay(final Subject subject) {
        this.subject = subject;
        this.temperatures = new ArrayList<>();

        this.subject.registerObserver(this);
    }

    @Override
    public void display() {
        final var average = temperatures.stream().mapToDouble(f -> (double) f).average().orElseThrow();
        final var max = temperatures.stream().mapToDouble(f -> (double) f).max().orElseThrow();
        final var min = temperatures.stream().mapToDouble(f -> (double) f).min().orElseThrow();

        System.out.println("Avg/Max/Min temperature = " + average + "/" + max + "/" + min);
    }

    @Override
    public void update(final float temperature, final float humidity, final float pressure) {
        this.temperatures.add(temperature);
        display();
    }
}
