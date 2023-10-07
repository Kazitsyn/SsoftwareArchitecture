package ru.archetecture.hw11.message.result;

import ru.archetecture.hw11.commands.base.CommandType;
import ru.archetecture.hw11.message.Message;

import java.util.List;
import java.util.Map;

public class ChatListResultMessage extends Message {
    private Map<Long, List<Long>> chatData;

    public ChatListResultMessage() {
        setType(CommandType.CHAT_LIST_RESULT);
    }

    public ChatListResultMessage(Map<Long, List<Long>> chatData) {
        this();
        this.chatData = chatData;
    }

    public Map<Long, List<Long>> getChatData() {
        return chatData;
    }

    public void setChatData(Map<Long, List<Long>> chatData) {
        this.chatData = chatData;
    }

    @Override
    public String toString() {
        return "ChatListResultMessage{" +
                "chatData=" + chatData +
                "} " + super.toString();
    }
}