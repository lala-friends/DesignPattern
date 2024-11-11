package main.java.com.example.designpatterns.chp12_compound;

public class DuckSimulator {
    public static void main(String[] args) {
        final var simulator = new DuckSimulator();
        final var duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(final AbstractDuckFactory duckFactory) {
        final var mallardDuck = duckFactory.createMallardDuck();
        final var redheadDuck = duckFactory.createRedheadDuck();
        final var duckCall = duckFactory.createDuckCall();
        final var rubberDuck = duckFactory.createRubberDuck();
        final var gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator\n");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void simulate(final Quackable duck) {
        duck.quack();
    }
}
