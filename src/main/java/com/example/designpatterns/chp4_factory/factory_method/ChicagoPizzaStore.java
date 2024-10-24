package main.java.com.example.designpatterns.chp4_factory.factory_method;

import main.java.com.example.designpatterns.chp4_factory.factory_method.pizza.*;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new ChicagoStyleCheesePizza();
            case "veggie" -> new ChicagoStyleVeggiePizza();
            case "clam" -> new ChicagoStyleClamPizza();
            case "pepperoni" -> new ChicagoStylePepperoniPizza();
            default -> null;
        };
    }
}
