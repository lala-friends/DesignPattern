package main.java.com.example.designpatterns.chp6_command.home_appliances;

public class Stereo {
    private final String name;

    public Stereo() {
        name = "";
    }

    public Stereo(final String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " stereo is on");
    }

    public void off() {
        System.out.println(name + " stereo is off");
    }

    public void setCd() {
        System.out.println(name + " stereo is set for CD input");
    }

    public void setDvd() {
        System.out.println(name + " stereo is set for DVD input");
    }

    public void setRadio() {
        System.out.println(name + " stereo is set for Radio input");
    }

    public void setVolume(int volume) {
        System.out.println(name + " stereo volume set to " + volume);
    }
}
