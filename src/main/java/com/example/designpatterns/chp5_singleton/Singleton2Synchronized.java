package main.java.com.example.designpatterns.chp5_singleton;

public class Singleton2Synchronized {
    private static Singleton2Synchronized uniqueInstance;

    private Singleton2Synchronized() {
    }

    // 한 쓰레드가 메소드의 사용을 끝나기 전까지 다른 쓰레드는 기다림
    public static synchronized Singleton2Synchronized getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton2Synchronized();
        }
        return uniqueInstance;
    }
}
