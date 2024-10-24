package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class NYStyleClamPizza extends Pizza {

    public NYStyleClamPizza() {
        super("NY Style Sauce and Clam Pizza"
                , "Thin Crust Dough"
                , "Marinara Sauce");
        addTopping("Clam");
    }
}
