package test.java.com.example.designpatterns.chp2_observer;

import main.java.com.example.designpatterns.chp2_observer.pull.CurrentConditionsDisplay;
import main.java.com.example.designpatterns.chp2_observer.pull.WeatherData;
import org.junit.jupiter.api.Test;

public class ObserverPullTest {
    @Test
    public void changeMeasurements() {
        final var subject = new WeatherData();

        final var observer = new CurrentConditionsDisplay(subject);

        subject.setMeasurements(80, 65);
        subject.setMeasurements(82, 70);
        subject.setMeasurements(78, 90);
    }
}
