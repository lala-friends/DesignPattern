package main.java.com.example.designpatterns.chp4_factory.simple_factory;

import main.java.com.example.designpatterns.chp4_factory.simple_factory.pizza.Pizza;

public class PizzaStore {
    private final SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(final String order) {
        final var pizza = simplePizzaFactory.createPizza(order);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
