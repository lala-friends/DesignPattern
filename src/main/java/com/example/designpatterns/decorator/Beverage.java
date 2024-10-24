package main.java.com.example.designpatterns.decorator;

public abstract class Beverage {
    private String description = "Unknown Beverage";
    private Size size;

    public Beverage() {
    }

    public Beverage(final String description, final Size size) {
        this.description = description;
        this.size = size;
    }

    public String getDescription() {
        return description + "(" + size + ")";
    }

    public Size getSize() {
        return size;
    }

    public abstract double cost();
}
