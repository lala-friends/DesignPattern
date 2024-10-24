package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class NYStylePepperoniPizza extends Pizza {
    public NYStylePepperoniPizza() {
        super("NY Style Sauce and Pepperoni Pizza"
                , "Thin Crust Dough"
                , "Marinara Sauce");
        addTopping("Pepperoni");
    }
}
