package main.java.com.example.designpatterns.chp12_compound;

import java.util.Objects;

public class GooseAdapter implements Quackable {
    private final Goose goose;

    public GooseAdapter(final Goose goose) {
        this.goose = Objects.requireNonNull(goose);
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
