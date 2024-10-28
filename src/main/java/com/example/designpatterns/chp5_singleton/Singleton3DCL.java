package main.java.com.example.designpatterns.chp5_singleton;

public class Singleton3DCL {
    private volatile static Singleton3DCL instance;

    private Singleton3DCL() {
    }

    public static Singleton3DCL getInstance() {
        if (instance == null) {
            synchronized (Singleton3DCL.class) {
                if (instance == null) {
                    instance = new Singleton3DCL();
                }
            }
        }
        return instance;
    }
}
