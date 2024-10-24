package main.java.com.example.designpatterns.chp2_observer.pull;

public class CurrentConditionsDisplay implements Observer, Display {
    private final Subject subject;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Subject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update(final Subject subject) {
        if (subject instanceof WeatherData weatherData) {
            temperature = weatherData.getTemperature();
            humidity = weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
