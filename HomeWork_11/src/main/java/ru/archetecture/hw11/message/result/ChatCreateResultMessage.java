package ru.archetecture.hw11.message.result;

import ru.archetecture.hw11.commands.base.CommandType;
import ru.archetecture.hw11.message.Message;

public class ChatCreateResultMessage extends Message {
    private Long newChatId;

    public ChatCreateResultMessage() {
        setType(CommandType.CHAT_CREATE_RESULT);
    }

    public ChatCreateResultMessage(Long newChatId) {
        this();
        this.newChatId = newChatId;
    }

    public Long getNewChatId() {
        return newChatId;
    }

    public void setNewChatId(Long newChatId) {
        this.newChatId = newChatId;
    }

    @Override
    public String toString() {
        return "ChatCreateResultMessage{" +
                "newChatId=" + newChatId +
                "} " + super.toString();
    }
}