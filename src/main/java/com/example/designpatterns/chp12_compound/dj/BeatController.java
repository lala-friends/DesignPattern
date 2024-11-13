package main.java.com.example.designpatterns.chp12_compound.dj;

import java.util.Objects;

public class BeatController implements ControllerInterface {
    private final BeatModelInterface model;
    private DJView view;

    public BeatController(final BeatModelInterface model) {
        this.model = Objects.requireNonNull(model);

        view = new DJView(model, this);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.initialize();
    }

    @Override
    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    @Override
    public void increaseBPM() {
        final var bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    @Override
    public void decreaseBPM() {
        final var bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }
}
