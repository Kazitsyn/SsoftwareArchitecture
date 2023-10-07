package ru.archetecture.hw11.message.result;

import ru.archetecture.hw11.commands.base.CommandType;
import ru.archetecture.hw11.message.Message;

import java.util.List;

public class ChatFindResultMessage extends Message {
    private List<String> messages;

    public ChatFindResultMessage() {
        setType(CommandType.CHAT_FIND_RESULT);
    }

    public ChatFindResultMessage(List<String> messages) {
        this();
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "ChatFindResultMessage{" +
                "messages=" + messages +
                "} " + super.toString();
    }
}