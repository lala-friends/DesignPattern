package main.java.com.example.designpatterns.chp8_template_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {
    @Override
    void brew() {
        System.out.println("필터로 커피를 우려내는 중");
    }

    @Override
    void addCondiments() {
        System.out.println("설탕과 커피를 추가하는 중");
    }

    @Override
    boolean customerWantsCondiments() {
        final var answer = getUserInput();

        return answer.toLowerCase().startsWith("y");
    }

    private String getUserInput() {
        String answer = null;

        System.out.print("커피에 우유와 설탕을 넣어 드릴까요? (y/n): ");

        final var in = new BufferedReader(new InputStreamReader(System.in));

        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.out.println("IO 오류!");
        }

        if (answer != null) {
            return "no";
        }

        return answer;
    }
}
