package ru.archetecture.hw11.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.archetecture.hw11.commands.base.Command;
import ru.archetecture.hw11.commands.base.CommandResultState;
import ru.archetecture.hw11.message.result.CommandResultMessage;
import ru.archetecture.hw11.message.Message;
import ru.archetecture.hw11.message.User;
import ru.archetecture.hw11.message.result.*;
import ru.archetecture.hw11.message.SendMessage;
import ru.archetecture.hw11.message.UserStore;
import ru.archetecture.hw11.session.Session;

/**
 * Поменять пароль
 */
public class UserPassCommand extends Command {

    static Logger log = LoggerFactory.getLogger(UserPassCommand.class);

    private UserStore userStore;

    public UserPassCommand() {
        super();
        name = "user_pass";
        description = "<old_pass> <new_pass> Сменить пароль (только для залогиненных пользователей).";
    }

    public UserPassCommand(UserStore userStore) {
        this();
        this.userStore = userStore;
    }

    @Override
    public Message execute(Session session, Message msg) {
        if (session.getSessionUser() == null) {
            log.info("User isn't logged in.");
            return new CommandResultMessage(CommandResultState.NOT_LOGGED, "You need to login.");
        }

        SendMessage userPassMsg = (SendMessage) msg;
        User user = userStore.getUserById(userPassMsg.getSender());

        String[] args = userPassMsg.getMessage().split(">");
        if (user.getPass().equals(args[0])) {
            user.setPass(args[1]);
            userStore.updateUser(user);
            session.setSessionUser(user);

            log.info("Success set_pass: {}", session.getSessionUser());
            return new CommandResultMessage(CommandResultState.OK, "Password is changed.");
        }
        log.info("set_pass: Wrong old password.");
        return new CommandResultMessage(CommandResultState.FAILED, "Invalid password.");
    }
}
