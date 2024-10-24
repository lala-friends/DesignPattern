package main.java.com.example.designpatterns.chp4_factory.factory_method;


import main.java.com.example.designpatterns.chp4_factory.factory_method.pizza.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(final String order) {
        final var pizza = createPizza(order);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
