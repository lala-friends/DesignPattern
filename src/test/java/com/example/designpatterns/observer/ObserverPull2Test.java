package test.java.com.example.designpatterns.observer;

import main.java.com.example.designpatterns.observer.pull2.CurrentConditionsDisplay;
import main.java.com.example.designpatterns.observer.pull2.WeatherData;
import org.junit.jupiter.api.Test;

public class ObserverPull2Test {
    @Test
    public void changeMeasurements() {
        final var subject = new WeatherData();

        final var observer = new CurrentConditionsDisplay(subject);

        subject.setMeasurements(80, 65);
        subject.setMeasurements(82, 70);
        subject.setMeasurements(78, 90);
    }
}
