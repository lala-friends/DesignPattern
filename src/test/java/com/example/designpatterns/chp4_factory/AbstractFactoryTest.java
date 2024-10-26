package test.java.com.example.designpatterns.chp4_factory;

import main.java.com.example.designpatterns.chp4_factory.abstract_factory.store.NYPizzaStore;
import org.junit.jupiter.api.Test;

public class AbstractFactoryTest {
    @Test
    public void test() {
        final var nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("cheese");
    }
}
