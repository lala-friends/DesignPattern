package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class ChicagoStyleClamPizza extends Pizza {
    public ChicagoStyleClamPizza() {
        super("Chicago Style Deep Dish Clam Pizza"
                , "Extra Thick Crust Dough"
                , "Plum Tomato Sauce");
        addTopping("Clam");
    }
}
