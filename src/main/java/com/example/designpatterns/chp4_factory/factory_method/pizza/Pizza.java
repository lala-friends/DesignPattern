package main.java.com.example.designpatterns.chp4_factory.factory_method.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    private final String name;
    private final String dough;
    private final String sauce;
    private final List<String> toppings;

    public Pizza(final String name, final String dough, final String sauce) {
        this.name = name;
        this.dough = dough;
        this.sauce = sauce;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(final String topping) {
        toppings.add(topping);
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough: " + dough);
        System.out.println("Adding sauce: " + sauce);
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.print(" " + topping);
        }
        System.out.println();
    }

    public void bake() {
        System.out.println("Baking pizza...");
    }

    public void cut() {
        System.out.println("Cutting pizza...");
    }

    public void box() {
        System.out.println("Boxing pizza...");
    }

    public String getName() {
        return name;
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }
}
