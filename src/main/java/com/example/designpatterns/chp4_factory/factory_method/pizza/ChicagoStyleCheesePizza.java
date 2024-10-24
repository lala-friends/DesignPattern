package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        super("Chicago Style Deep Dish Cheese Pizza"
                , "Extra Thick Crust Dough"
                , "Plum Tomato Sauce");
        addTopping("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
