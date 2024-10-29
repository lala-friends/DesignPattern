package main.java.com.example.designpatterns.chp6_command;

import main.java.com.example.designpatterns.chp6_command.command.Command;
import main.java.com.example.designpatterns.chp6_command.command.NoCommand;

public class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        for (int i = 0; i < onCommands.length; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }

        undoCommand = new NoCommand();
    }

    public void setCommand(final int index, final Command onCommand, final Command offCommand) {
        onCommands[index] = onCommand;
        offCommands[index] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot].execute();
        setUndoCommand(onCommands[slot]);
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot].execute();
        setUndoCommand(offCommands[slot]);
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n---------- Remote Control -----------\n");
        for (int i = 0; i < onCommands.length; i++) {
            final var str = "[slot " + i + "] "
                    + onCommands[i].getClass().getName()
                    + "    "
                    + offCommands[i].getClass().getName() + "\n";
            stringBuilder.append(str);
        }

        return stringBuilder.toString();
    }

    private void setUndoCommand(Command undoCommand) {
        this.undoCommand = undoCommand;
    }
}
