package main.java.com.example.designpatterns.chp12_compound;

public class DuckSimulator {
    public static void main(String[] args) {
        final var simulator = new DuckSimulator();
        simulator.simulate();
    }

    void simulate() {
        final var mallardDuck = new QuackCounter(new MallardDuck());
        final var redheadDuck = new QuackCounter(new RedheadDuck());
        final var duckCall = new QuackCounter(new DuckCall());
        final var rubberDuck = new QuackCounter(new RubberDuck());
        final var gooseDuck = new QuackCounter(new GooseAdapter(new Goose()));

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
