package main.java.com.example.designpatterns.chp4_factory.factory_method;

import main.java.com.example.designpatterns.chp4_factory.factory_method.pizza.*;

public class NyPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new NYStyleCheesePizza();
            case "veggie" -> new NYStyleVeggiePizza();
            case "clam" -> new NYStyleClamPizza();
            case "pepperoni" -> new NYStylePepperoniPizza();
            default -> null;
        };
    }
}
