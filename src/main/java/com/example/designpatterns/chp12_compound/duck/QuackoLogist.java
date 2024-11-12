package main.java.com.example.designpatterns.chp12_compound.duck;

public class QuackoLogist implements Observer {
    @Override
    public void update(final QuackObservable duck) {
        System.out.println("Quackologist: " + duck + " just quacked");
    }
}
