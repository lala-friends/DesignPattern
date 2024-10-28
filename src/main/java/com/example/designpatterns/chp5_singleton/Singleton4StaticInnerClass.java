package main.java.com.example.designpatterns.chp5_singleton;

public class Singleton4StaticInnerClass {
    private Singleton4StaticInnerClass() {
    }

    private static class SingletonHolder {
        private static final Singleton4StaticInnerClass INSTANCE = new Singleton4StaticInnerClass();
    }

    public static Singleton4StaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
