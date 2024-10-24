package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class CaliforniaStylePepperoniPizza extends Pizza {
    public CaliforniaStylePepperoniPizza() {
        super("Chicago Style Pepperoni Pizza"
                , "dough"
                , "sauce");
        addTopping("Pepperoni");
    }
}
