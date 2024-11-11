package main.java.com.example.designpatterns.chp12_compound;

public class DuckSimulator {
    public static void main(String[] args) {
        final var simulator = new DuckSimulator();
        simulator.simulate();
    }

    void simulate() {
        final var mallardDuck = new MallardDuck();
        final var redheadDuck = new RedheadDuck();
        final var duckCall = new DuckCall();
        final var rubberDuck = new RubberDuck();

        System.out.println("\nDuck Simulator\n");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
    }

    void simulate(final Quackable duck) {
        duck.quack();
    }
}
