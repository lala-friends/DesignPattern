package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class CaliforniaStyleVeggiePizza extends Pizza {
    public CaliforniaStyleVeggiePizza() {
        super("Chicago Style Veggie Pizza"
                , "dough"
                , "sauce");
        addTopping("Veggie");
    }
}
