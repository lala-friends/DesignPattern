package test.java.com.example.designpatterns.chp7_adapter_and_facade;

import main.java.com.example.designpatterns.chp7_adapter_and_facade.facade.*;
import org.junit.jupiter.api.Test;

public class FacadeTest {
    @Test
    public void testFacade() {
        final var homeTheater = new HomeTheaterFacade(
                new Amplifier(),
                new Tuner(),
                new DvdPlayer(),
                new CdPlayer(),
                new Projector(),
                new TheaterLights(),
                new Screen(),
                new PopcornPopper()
        );

        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();

    }
}
