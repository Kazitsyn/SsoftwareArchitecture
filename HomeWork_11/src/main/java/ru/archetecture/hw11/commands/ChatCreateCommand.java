package ru.archetecture.hw11.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.archetecture.hw11.commands.base.Command;
import ru.archetecture.hw11.commands.base.CommandResultState;
import ru.archetecture.hw11.message.*;
import ru.archetecture.hw11.message.result.ChatCreateResultMessage;
import ru.archetecture.hw11.message.result.CommandResultMessage;
import ru.archetecture.hw11.message.*;
import ru.archetecture.hw11.message.result.*;
import ru.archetecture.hw11.session.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Создать новый чат
 */
public class ChatCreateCommand extends Command {

    static Logger log = LoggerFactory.getLogger(ChatCreateCommand.class);

    private MessageStore messageStore;
    private UserStore userStore;

    public ChatCreateCommand() {
        super();
        name = "chat_create";
        description = "<user_id list> Создать новый чат, " +
                "список пользователей приглашенных в чат (только для залогиненных пользователей).";
    }

    public ChatCreateCommand(UserStore userStore, MessageStore messageStore) {
        this();
        this.messageStore = messageStore;
        this.userStore = userStore;
    }


    @Override
    public Message execute(Session session, Message msg) {
        if (session.getSessionUser() == null) {
            log.info("User isn't logged in.");
            return new CommandResultMessage(CommandResultState.NOT_LOGGED, "You need to login.");
        }

        SendMessage chatCreateMsg = (SendMessage) msg;

        List<Long> participants = new ArrayList<>();

        participants.add(session.getSessionUser().getId());
        for (String arg : chatCreateMsg.getMessage().split(",")) {
            Long id = Long.parseLong(arg);
            User user = userStore.getUserById(id);
            if (user == null) {
                log.info("Failed chat_create: {}", id);
                return new CommandResultMessage(CommandResultState.FAILED, "User " + id + " doesn't exist.");
            } else if (!id.equals(session.getSessionUser().getId())) {
                // Защита от дурака, т.е. если среди id будет id пользователя
                participants.add(id);
            }
        }

        Chat newChat = messageStore.createChat(participants);
        log.info("Success chat_create: {}", newChat);
        return new ChatCreateResultMessage(newChat.getId());
    }
}
