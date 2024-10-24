package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class ChicagoStylePepperoniPizza extends Pizza {
    public ChicagoStylePepperoniPizza() {
        super("Chicago Style Deep Dish Pepperoni Pizza"
                , "Extra Thick Crust Dough"
                , "Plum Tomato Sauce");
        addTopping("Pepperoni");
    }
}
