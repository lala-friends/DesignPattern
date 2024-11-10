package main.java.com.example.designpatterns.chp11_proxy.protect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class NonOwnerInvocationHandler implements InvocationHandler {
    private final PersonBean person;

    public NonOwnerInvocationHandler(final PersonBean person) {
        this.person = Objects.requireNonNull(person);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                return method.invoke(person, args);
            } else if (method.getName().startsWith("set")) {
                throw new IllegalAccessException();
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
