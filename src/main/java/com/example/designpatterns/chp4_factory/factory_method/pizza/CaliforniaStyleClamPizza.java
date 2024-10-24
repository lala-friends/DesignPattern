package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class CaliforniaStyleClamPizza extends Pizza {
    public CaliforniaStyleClamPizza() {
        super("Chicago Style Clam Pizza"
                , "dough"
                , "sauce");
        addTopping("Clam");
    }
}
