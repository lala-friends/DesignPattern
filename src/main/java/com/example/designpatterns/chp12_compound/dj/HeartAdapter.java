package main.java.com.example.designpatterns.chp12_compound.dj;

import java.util.Objects;

public class HeartAdapter implements BeatModelInterface {
    private final HeartModelInterface heart;

    public HeartAdapter(final HeartModelInterface heart) {
        this.heart = Objects.requireNonNull(heart);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public void setBPM(int bpm) {
    }

    @Override
    public int getBPM() {
        return heart.getHeartRate();
    }

    @Override
    public void registerObserver(final BeatObserver observer) {
        heart.registerBeatObserver(observer);
    }

    @Override
    public void removeObserver(final BeatObserver observer) {
        heart.removeBeatObserver(observer);
    }

    @Override
    public void registerObserver(final BPMObserver observer) {
        heart.registerBPMObserver(observer);
    }

    @Override
    public void removeObserver(final BPMObserver observer) {
        heart.removeBPMObserver(observer);
    }
}
