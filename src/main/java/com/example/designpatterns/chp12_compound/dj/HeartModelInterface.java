package main.java.com.example.designpatterns.chp12_compound.dj;

public interface HeartModelInterface {
    int getHeartRate();

    void registerBeatObserver(BeatObserver observer);

    void removeBeatObserver(BeatObserver observer);

    void registerBPMObserver(BPMObserver observer);

    void removeBPMObserver(BPMObserver observer);
}
