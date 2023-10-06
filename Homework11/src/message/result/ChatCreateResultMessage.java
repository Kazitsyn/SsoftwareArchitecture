package message.result;

import commands.base.CommandType;
import message.Message;

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