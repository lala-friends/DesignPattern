package main.java.com.example.designpatterns.chp12_compound.dj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeartModel implements HeartModelInterface, Runnable {
    private final List<BeatObserver> beatObservers = new ArrayList<>();
    private final List<BPMObserver> bpmObservers = new ArrayList<>();
    private int time = 1000;
    private int bpm = 90;
    private Random random = new Random(System.currentTimeMillis());
    private Thread thread;

    public HeartModel() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        int lastrate = -1;

        while (true) {
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0) {
                change = 0 - change;
            }
            int rate = 60000 / (time + change);
            if (rate < 120 && rate > 50) {
                time += change;
                notifyBeatObservers();
                if (rate != lastrate) {
                    lastrate = rate;
                    notifyBPMObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        }
    }

    public int getHeartRate() {
        return 60000 / time;
    }

    @Override
    public void registerBeatObserver(final BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void removeBeatObserver(final BeatObserver observer) {
        int i = beatObservers.indexOf(observer);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    @Override
    public void registerBPMObserver(BPMObserver observer) {
        bpmObservers.add(observer);
    }

    @Override
    public void removeBPMObserver(BPMObserver observer) {
        int i = bpmObservers.indexOf(observer);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    public void notifyBeatObservers() {
        for (int i = 0; i < beatObservers.size(); i++) {
            BeatObserver observer = (BeatObserver) beatObservers.get(i);
            observer.updateBeat();
        }
    }

    public void notifyBPMObservers() {
        for (int i = 0; i < bpmObservers.size(); i++) {
            BPMObserver observer = (BPMObserver) bpmObservers.get(i);
            observer.updateBPM();
        }
    }
}
