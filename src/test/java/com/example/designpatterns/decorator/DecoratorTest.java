package test.java.com.example.designpatterns.decorator;

import main.java.com.example.designpatterns.decorator.Size;
import main.java.com.example.designpatterns.decorator.coffee.DarkRoast;
import main.java.com.example.designpatterns.decorator.coffee.Espresso;
import main.java.com.example.designpatterns.decorator.coffee.HouseBlend;
import main.java.com.example.designpatterns.decorator.condiment.Mocha;
import main.java.com.example.designpatterns.decorator.condiment.Soy;
import main.java.com.example.designpatterns.decorator.condiment.Whip;
import org.junit.jupiter.api.Test;

public class DecoratorTest {

    @Test
    public void testDecoratorPattern() {
        final var beverage1 = new Espresso();
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        final var beverage2 = new Whip(new Mocha(new Mocha(new DarkRoast())));
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        final var beverage3 = new Whip(new Mocha(new Soy(new HouseBlend())));
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }

    @Test
    void testSize() {
        final var beverage1 = new Soy(new Espresso(Size.TALL));
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        final var beverage2 = new Soy(new Espresso(Size.GRANDE));
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        final var beverage3 = new Soy(new Espresso(Size.VENTI));
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
