package ru.archetecture.hw11.commands.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.archetecture.hw11.message.Message;
import ru.archetecture.hw11.net.MessageListener;
import ru.archetecture.hw11.session.Session;

import java.io.IOException;
import java.util.Map;

/**
 *
 */
public class CommandHandler implements MessageListener {

    static Logger log = LoggerFactory.getLogger(CommandHandler.class);

    Map<CommandType, Command> commands;

    public CommandHandler(Map<CommandType, Command> commands) {
        this.commands = commands;
    }

    @Override
    public void onMessage(Session session, Message message) {
        Command cmd = commands.get(message.getType());
        if (session.getSessionUser() != null) {
            message.setSender(session.getSessionUser().getId());
        }
        log.info("Set sender:" + session.getSessionUser());

        log.info("onMessage: {} type {}", message, message.getType());

        Message result = cmd.execute(session, message);

        if (result != null) {
            try {
                session.getConnectionHandler().send(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
