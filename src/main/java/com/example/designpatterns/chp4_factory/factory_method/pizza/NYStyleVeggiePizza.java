package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        super("NY Style Sauce and Veggie Pizza"
                , "Thin Crust Dough"
                , "Marinara Sauce");
        addTopping("Veggie");
    }
}
