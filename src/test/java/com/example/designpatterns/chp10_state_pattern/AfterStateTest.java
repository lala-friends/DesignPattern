package test.java.com.example.designpatterns.chp10_state_pattern;

import main.java.com.example.designpatterns.chp10_state_pattern.state.GumballMachine;
import org.junit.jupiter.api.Test;

public class AfterStateTest {
    @Test
    public void test() {
        final var gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
