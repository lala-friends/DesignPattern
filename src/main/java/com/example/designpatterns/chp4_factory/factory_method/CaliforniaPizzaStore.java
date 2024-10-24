package main.java.com.example.designpatterns.chp4_factory.factory_method;

import main.java.com.example.designpatterns.chp4_factory.factory_method.pizza.*;

public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new CaliforniaStyleCheesePizza();
            case "veggie" -> new CaliforniaStyleVeggiePizza();
            case "clam" -> new CaliforniaStyleClamPizza();
            case "pepperoni" -> new CaliforniaStylePepperoniPizza();
            default -> null;
        };
    }
}
