package main.java.com.example.designpatterns.chp4_factory.abstract_factory.pizza;

import main.java.com.example.designpatterns.chp4_factory.abstract_factory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    private final PizzaIngredientFactory ingredientFactory;

    public CheesePizza(final String name, final PizzaIngredientFactory ingredientFactory) {
        super(name);
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + super.getName());
        super.setDough(ingredientFactory.createDough());
        super.setSauce(ingredientFactory.createSauce());
        super.setCheese(ingredientFactory.createCheese());
    }
}