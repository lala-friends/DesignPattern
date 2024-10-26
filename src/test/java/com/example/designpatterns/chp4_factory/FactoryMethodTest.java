package test.java.com.example.designpatterns.chp4_factory;

import main.java.com.example.designpatterns.chp4_factory.factory_method.ChicagoPizzaStore;
import main.java.com.example.designpatterns.chp4_factory.factory_method.NyPizzaStore;
import org.junit.jupiter.api.Test;

public class FactoryMethodTest {
    @Test
    public void testFactoryMethod() {
        final var nyStore = new NyPizzaStore();
        final var nyCheesePizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + nyCheesePizza.getName());

        final var chicagoStore = new ChicagoPizzaStore();
        final var chicagoCheesePizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + chicagoCheesePizza.getName());
    }
}
