package main.java.com.example.designpatterns.chp5_singleton;

public class Singleton1Classic {
    private static Singleton1Classic uniqueInstance;

    private Singleton1Classic() {
    }

    public static Singleton1Classic getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1Classic();
        }
        return uniqueInstance;
    }
}
