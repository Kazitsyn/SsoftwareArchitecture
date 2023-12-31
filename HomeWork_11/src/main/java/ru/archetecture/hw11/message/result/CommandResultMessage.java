package ru.archetecture.hw11.message.result;

import ru.archetecture.hw11.commands.base.CommandResultState;
import ru.archetecture.hw11.commands.base.CommandType;
import ru.archetecture.hw11.message.Message;

public class CommandResultMessage extends Message {
    private CommandResultState state;
    private String data;

    public CommandResultMessage() {
        setType(CommandType.COMMAND_RESULT);
    }

    public CommandResultMessage(CommandResultState state, String data) {
        this();
        this.state = state;
        this.data = data;
    }

    public CommandResultState getState() {
        return state;
    }

    public void setState(CommandResultState state) {
        this.state = state;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommandResultMessage{" +
                "state=" + state +
                ", data='" + data + '\'' +
                "} " + super.toString();
    }
}