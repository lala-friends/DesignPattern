package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        super("NY Style Sauce and Cheese Pizza"
                , "Thin Crust Dough"
                , "Marinara Sauce");
        addTopping("Grated Reggiano Cheese");
    }
}
