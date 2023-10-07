package ru.archetecture.hw11.message.result;

import ru.archetecture.hw11.commands.base.CommandType;
import ru.archetecture.hw11.message.Message;

import java.util.List;

public class HelpResultMessage extends Message {
    private List<String> helpContent;

    public HelpResultMessage() {
        setType(CommandType.HELP_RESULT);
    }

    public HelpResultMessage(List<String> helpContent) {
        this();
        this.helpContent = helpContent;
    }

    public List<String> getHelpContent() {
        return helpContent;
    }

    public void setHelpContent(List<String> helpContent) {
        this.helpContent = helpContent;
    }

    @Override
    public String toString() {
        return "HelpResultMessage{" +
                "helpContent=" + helpContent +
                "} " + super.toString();
    }
}