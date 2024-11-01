package main.java.com.example.designpatterns.chp7_adapter_and_facade;

public class DuckAdapter implements Turkey {
    private final Duck duck;

    public DuckAdapter(final Duck duck) {
        this.duck = duck;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
