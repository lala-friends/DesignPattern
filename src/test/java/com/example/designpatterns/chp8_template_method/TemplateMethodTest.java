package test.java.com.example.designpatterns.chp8_template_method;

import main.java.com.example.designpatterns.chp8_template_method.CaffeineBeverage;
import main.java.com.example.designpatterns.chp8_template_method.Coffee;
import main.java.com.example.designpatterns.chp8_template_method.Tea;
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {
    @Test
    public void testCaffeineBeverage() {
        final CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();

        final CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
