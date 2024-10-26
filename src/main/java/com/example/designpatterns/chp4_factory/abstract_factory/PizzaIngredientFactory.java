package main.java.com.example.designpatterns.chp4_factory.abstract_factory;

import main.java.com.example.designpatterns.chp4_factory.abstract_factory.ingredients.*;

public interface PizzaIngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClams();
}
