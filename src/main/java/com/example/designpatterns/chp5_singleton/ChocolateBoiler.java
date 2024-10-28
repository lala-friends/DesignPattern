package main.java.com.example.designpatterns.chp5_singleton;

public class ChocolateBoiler {
    private static ChocolateBoiler instance;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            instance = new ChocolateBoiler();
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            setEmpty(false);
            setBoiled(false);
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            setBoiled(true);
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            setEmpty(true);
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isBoiled() {
        return boiled;
    }

    public void setBoiled(boolean boiled) {
        this.boiled = boiled;
    }
}
