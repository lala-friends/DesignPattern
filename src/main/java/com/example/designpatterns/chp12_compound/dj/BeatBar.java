package main.java.com.example.designpatterns.chp12_compound.dj;

import javax.swing.*;
import java.io.Serial;

public class BeatBar extends JProgressBar implements Runnable {
    @Serial
    private static final long serialVersionUID = 2L;
    Thread thread;

    public BeatBar() {
        thread = new Thread(this);
        setMaximum(100);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            int value = getValue();
            value = (int) (value * 0.75); // 감소 비율 설정
            setValue(value);
            repaint();
            try {
                Thread.sleep(50); // 50ms마다 업데이트
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}