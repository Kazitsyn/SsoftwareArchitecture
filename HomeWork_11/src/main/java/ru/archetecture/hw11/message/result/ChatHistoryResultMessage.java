package ru.archetecture.hw11.message.result;

import ru.archetecture.hw11.commands.base.CommandType;
import ru.archetecture.hw11.message.Message;

import java.util.List;

public class ChatHistoryResultMessage extends Message {
    private List<String> messages;

    public ChatHistoryResultMessage() {
        setType(CommandType.CHAT_HISTORY_RESULT);
    }

    public ChatHistoryResultMessage(List<String> messages) {
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
        return "ChatHistoryResultMessage{" +
                "messages=" + messages +
                "} " + super.toString();
    }
}