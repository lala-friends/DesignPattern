package test.java.com.example.designpatterns.observer;

import main.java.com.example.designpatterns.observer.push.observer.CurrentConditionsDisplay;
import main.java.com.example.designpatterns.observer.push.observer.ForecastDisplay;
import main.java.com.example.designpatterns.observer.push.observer.HeatIndexDisplay;
import main.java.com.example.designpatterns.observer.push.observer.StatisticDisplay;
import main.java.com.example.designpatterns.observer.push.subject.WeatherData;
import org.junit.jupiter.api.Test;

public class ObserverPushTest {
    @Test
    public void changeMeasurements() {
        final var subject = new WeatherData();

        final var observer1 = new CurrentConditionsDisplay(subject);
        final var observer2 = new StatisticDisplay(subject);
        final var observer3 = new ForecastDisplay(subject);
        final var observer4 = new HeatIndexDisplay(subject);

        subject.setMeasurements(80, 65, 30.4f);
        subject.setMeasurements(82, 70, 29.2f);
        subject.setMeasurements(78, 90, 29.2f);
    }
}
