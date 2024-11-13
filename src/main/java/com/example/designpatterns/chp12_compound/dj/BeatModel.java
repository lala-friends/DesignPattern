package main.java.com.example.designpatterns.chp12_compound.dj;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.List;

public class BeatModel implements BeatModelInterface, MetaEventListener {
    private Sequencer sequencer;
    private final List<BeatObserver> beatObservers = new ArrayList<>();
    private final List<BPMObserver> bpmObservers = new ArrayList<>();
    private int bpm;
    private Sequence sequence;
    private Track track;

    @Override
    public void initialize() {
        setUpMidi();
        buildTrackAndStart();
    }

    private void buildTrackAndStart() {
        final int[] trackList = {35, 0, 46, 0};

        sequence.deleteTrack(null);
        track = sequence.createTrack();

        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));

        try {
            sequencer.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MidiEvent makeEvent(final int command, final int chan, final int one, final int two, final int tick) {
        MidiEvent event = null;

        try {
            ShortMessage message = new ShortMessage();
            message.setMessage(command, chan, one, two);
            event = new MidiEvent(message, tick);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return event;
    }

    private void makeTracks(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                if (key != 0) {
                    track.add(makeEvent(144, 9, key, 100, i));
                    MidiEvent midiEvent =
                            makeEvent(128, 9, key, 100, i + 1);
                    track.add(midiEvent);
                    track.add(makeMetaEvent(midiEvent, i + 2));
                }
            }
        }
    }

    private MidiEvent makeMetaEvent(MidiEvent midiEvent, int tick) {
        MidiEvent event = null;

        try {
            MetaMessage message = new MetaMessage(47,
                    midiEvent.getMessage().getMessage(),
                    midiEvent.getMessage().getLength());
            event = new MidiEvent(message, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

        return event;
    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
            sequencer.addMetaEventListener(meta -> {
                if (meta.getType() == 47) {
                    sequencer.setTickPosition(0);
                    sequencer.start();
                    beatEvent();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void on() {
        sequencer.start();
        setBPM(90);
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    private void notifyBPMObservers() {
        for (BPMObserver observer : bpmObservers) {
            observer.updateBPM();
        }
    }

    private void notifyBeatObservers() {
        for (BeatObserver beatObserver : beatObservers) {
            beatObserver.updateBeat();
        }
    }


    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void registerObserver(final BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        final var index = beatObservers.indexOf(observer);
        if (index != -1) {
            beatObservers.remove(index);
        }
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        bpmObservers.add(observer);
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        final var index = bpmObservers.indexOf(observer);
        if (index != -1) {
            bpmObservers.remove(index);
        }
    }

    @Override
    public void meta(final MetaMessage meta) {
        if (meta.getType() == 47) {
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    private void beatEvent() {
        notifyBeatObservers();
    }
}
