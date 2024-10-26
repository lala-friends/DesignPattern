package main.java.com.example.designpatterns.chp4_factory.abstract_factory.store;

import main.java.com.example.designpatterns.chp4_factory.abstract_factory.NYPizzaIngredientFactory;
import main.java.com.example.designpatterns.chp4_factory.abstract_factory.PizzaIngredientFactory;
import main.java.com.example.designpatterns.chp4_factory.abstract_factory.pizza.*;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(final String type) {
        final PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

        return switch (type) {
            case "cheese" -> new CheesePizza("New York Style Cheese Pizza", pizzaIngredientFactory);
            case "veggie" -> new VeggiePizza("New York Style Veggie Pizza", pizzaIngredientFactory);
            case "clam" -> new ClamPizza("New York Style Clam Pizza", pizzaIngredientFactory);
            case "pepperoni" -> new PepperoniPizza("New York Style Pepperoni Pizza", pizzaIngredientFactory);
            default -> null;
        };
    }
}
