package main.java.com.example.designpatterns.chp12_compound.dj;

import java.util.Objects;

public class HeartController implements ControllerInterface {
    private final HeartModelInterface model;
    private final DJView view;

    public HeartController(final HeartModelInterface model) {
        this.model = Objects.requireNonNull(model);

        this.view = new DJView(new HeartAdapter(model), this);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void increaseBPM() {

    }

    @Override
    public void decreaseBPM() {

    }

    @Override
    public void setBPM(int bpm) {

    }
}
