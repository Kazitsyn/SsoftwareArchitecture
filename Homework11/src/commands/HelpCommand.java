package commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import commands.base.Command;
import commands.base.CommandType;
import message.Message;
import message.result.*;
import session.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Вывести помощь
 */
public class HelpCommand extends Command {

    static Logger log = LoggerFactory.getLogger(HelpCommand.class);

    private Map<CommandType, Command> commands;

    public HelpCommand() {
        super();
        name = "help";
        description = "\t<> Показать список команд и общий хэлп по мессенджеру.";
    }

    public HelpCommand(Map<CommandType, Command> commands) {
        this();
        this.commands = commands;
    }


    @Override
    public Message execute(Session session, Message msg) {
        HelpResultMessage helpResultMessage = new HelpResultMessage();
        List<String> helpContent = new ArrayList<>(commands.size());
        for (Command cmd : new TreeMap<>(commands).values()) {
            helpContent.add(cmd.getName() + "\t" + cmd.getDescription());
        }
        helpResultMessage.setHelpContent(helpContent);

        return helpResultMessage;
    }
}
