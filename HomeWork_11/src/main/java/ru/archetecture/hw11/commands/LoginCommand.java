package ru.archetecture.hw11.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.archetecture.hw11.commands.base.Command;
import ru.archetecture.hw11.commands.base.CommandResultState;
import ru.archetecture.hw11.message.result.CommandResultMessage;
import ru.archetecture.hw11.message.result.LoginResultMessage;
import ru.archetecture.hw11.AuthorizationService;
import ru.archetecture.hw11.message.LoginMessage;
import ru.archetecture.hw11.message.Message;
import ru.archetecture.hw11.message.User;
import ru.archetecture.hw11.message.result.*;
import ru.archetecture.hw11.net.SessionManager;
import ru.archetecture.hw11.session.Session;

/**
 * Выполняем авторизацию по этой команде
 */
public class LoginCommand extends Command {

    static Logger log = LoggerFactory.getLogger(LoginCommand.class);

    private AuthorizationService authService;
    private SessionManager sessionManager;

    public LoginCommand() {
        super();
        name = "login";
        description = "\t<login> <password> или <> Залогиниться или зарегестрироваться.";
    }

    public LoginCommand(AuthorizationService authService, SessionManager sessionManager) {
        this();
        this.authService = authService;
        this.sessionManager = sessionManager;
    }


    @Override
    public Message execute(Session session, Message msg) {

        LoginMessage loginMsg = (LoginMessage) msg;
        String name = loginMsg.getLogin();
        String password = loginMsg.getPass();
        switch (loginMsg.getArgType()) {
            case LOGIN:
                /*if (session.getSessionUser() == null) {
                    log.info("User {} already logged in.", session.getSessionUser());
                    return new CommandResultMessage(CommandResultState.NOT_LOGGED, "You have already logged in.");
                }*/

                User user = authService.login(name, password);
                if (user == null) {
                    log.info("Failed login: {}");
                    return new CommandResultMessage(CommandResultState.FAILED, "Invalid login or password.");
                } else {
                    session.setSessionUser(user);
                    sessionManager.registerUser(user.getId(), session.getId());
                    log.info("Success login: {}", user);
                    UserInfoCommand userInfoCommand = new UserInfoCommand(authService.getUserStore());

                    // Вывести информацию о себе
                    LoginMessage userInfoMessage = new LoginMessage();
                    userInfoMessage.setArgType(LoginMessage.ArgType.SELF_INFO);
                    return userInfoCommand.execute(session, userInfoMessage);
                }
            case CREAT_USER:
                User newUser = authService.creatUser(name, password);
                if (newUser == null) {
                    log.info("creat_user: The user with this name has already existed.");
                    return new CommandResultMessage(CommandResultState.FAILED,
                            "The user with this name has already existed.");
                } else {
                    log.info("Success registration: {}", newUser);
                    return new LoginResultMessage(newUser.getName(), newUser.getId());
                }
            default:
                log.info("Wrong argType: {}", loginMsg.getArgType());
                break;
        }
        return new CommandResultMessage(CommandResultState.FAILED, "Wrong argType: {}");
    }
}
