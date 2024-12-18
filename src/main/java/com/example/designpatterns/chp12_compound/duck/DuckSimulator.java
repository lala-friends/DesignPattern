package main.java.com.example.designpatterns.chp12_compound.duck;

public class DuckSimulator {
    public static void main(String[] args) {
        final var simulator = new DuckSimulator();
        final var duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(final AbstractDuckFactory duckFactory) {
        final var redheadDuck = duckFactory.createRedheadDuck();
        final var duckCall = duckFactory.createDuckCall();
        final var rubberDuck = duckFactory.createRubberDuck();
        final var gooseDuck = new GooseAdapter(new Goose());

        final var flocksOfDucks = new Flock();
        flocksOfDucks.add(redheadDuck);
        flocksOfDucks.add(duckCall);
        flocksOfDucks.add(rubberDuck);
        flocksOfDucks.add(gooseDuck);

        final var mallardOne = duckFactory.createMallardDuck();
        final var mallardTwo = duckFactory.createMallardDuck();
        final var mallardThree = duckFactory.createMallardDuck();
        final var mallardFour = duckFactory.createMallardDuck();

        final var flockOfMallard = new Flock();
        flockOfMallard.add(mallardOne);
        flockOfMallard.add(mallardTwo);
        flockOfMallard.add(mallardThree);
        flockOfMallard.add(mallardFour);

        flocksOfDucks.add(flockOfMallard);

        final var quackologist = new QuackoLogist();
        flocksOfDucks.registerObserver(quackologist);

        System.out.println("\nDuck Simulator: Whole Flock Simulation\n");
        simulate(flocksOfDucks);
    }

    void simulate(final Quackable duck) {
        duck.quack();
    }
}
