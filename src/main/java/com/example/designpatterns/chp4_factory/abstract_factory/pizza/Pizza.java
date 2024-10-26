package main.java.com.example.designpatterns.chp4_factory.abstract_factory.pizza;

import main.java.com.example.designpatterns.chp4_factory.abstract_factory.ingredients.*;

public abstract class Pizza {
    private final String name;
    private Dough dough;
    private Sauce sauce;
    private Cheese cheese;
    private Clams clam;
    private Veggies[] veggies;
    private Pepperoni pepperoni;

    public Pizza(final String name) {
        this.name = name;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public void setClam(Clams clam) {
        this.clam = clam;
    }

    public void setVeggies(Veggies[] veggies) {
        this.veggies = veggies;
    }

    public void setPepperoni(Pepperoni pepperoni) {
        this.pepperoni = pepperoni;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                '}';
    }
}
