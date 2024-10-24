package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class CaliforniaStyleCheesePizza extends Pizza {
    public CaliforniaStyleCheesePizza() {
        super("Chicago Style Cheese Pizza"
                , "dough"
                , "sauce");
        addTopping("Cheese");
    }
}
