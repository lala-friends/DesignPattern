package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        super("Chicago Style Deep Dish Veggie Pizza"
                , "Extra Thick Crust Dough"
                , "Plum Tomato Sauce");
        addTopping("Veggie");
    }
}
