package main.java.com.example.designpatterns.chp12_compound;

import java.util.Objects;

public class QuackCounter implements Quackable {
    private static int numberOfQuacks;
    private final Quackable duck;

    public QuackCounter(final Quackable duck) {
        numberOfQuacks = 0;
        this.duck = Objects.requireNonNull(duck);
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks += 1;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }
}
