package commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import commands.base.Command;
import commands.base.CommandResultState;
import message.Chat;
import message.Message;
import message.result.*;
import message.MessageStore;
import message.SendMessage;
import session.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Вывести список всех чатов пользователя
 */
public class ChatListCommand extends Command {

    static Logger log = LoggerFactory.getLogger(ChatListCommand.class);

    private MessageStore messageStore;

    public ChatListCommand() {
        super();
        name = "chat_list";
        description = "<> Получить список чатов пользователя (только для залогиненных пользователей)";
    }

    public ChatListCommand(MessageStore messageStore) {
        this();
        this.messageStore = messageStore;
    }


    @Override
    public Message execute(Session session, Message msg) {
        if (session.getSessionUser() == null) {
            log.info("User isn't logged in.");
            return new CommandResultMessage(CommandResultState.NOT_LOGGED, "You need to login.");
        }

        SendMessage chatListMsg = (SendMessage) msg;
        List<Long> chatIdList = messageStore.getChatsByUserId(chatListMsg.getSender());
        Map<Long, List<Long>> chatData = new HashMap<>(chatIdList.size());
        for (Long chatId : chatIdList) {
            Chat chat = messageStore.getChatById(chatId);
            chatData.put(chatId, chat.getParticipantIds());
        }
        if (chatData.isEmpty()) {
            return new CommandResultMessage(CommandResultState.OK, "You have no any chats.");
        }
        return new ChatListResultMessage(chatData);
    }
}
