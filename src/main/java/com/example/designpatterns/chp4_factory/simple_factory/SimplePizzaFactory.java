package main.java.com.example.designpatterns.chp4_factory.simple_factory;

import main.java.com.example.designpatterns.chp4_factory.simple_factory.pizza.*;

public class SimplePizzaFactory {
    public Pizza createPizza(final String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
