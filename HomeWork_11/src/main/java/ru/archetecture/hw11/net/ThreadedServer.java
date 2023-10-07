package ru.archetecture.hw11.net;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.archetecture.hw11.commands.*;
import ru.archetecture.hw11.commands.base.Command;
import ru.archetecture.hw11.commands.base.CommandHandler;
import ru.archetecture.hw11.commands.base.CommandType;
import ru.archetecture.hw11.jdbc.MessageDatabaseStore;
import ru.archetecture.hw11.jdbc.UserDatabaseStore;
import ru.archetecture.hw11.message.MessageStore;
import ru.archetecture.hw11.message.UserStore;
import ru.archetecture.hw11.serialization.Protocol;
import ru.archetecture.hw11.serialization.SerializationProtocol;
import ru.archetecture.hw11.commands.*;
import ru.archetecture.hw11.AuthorizationService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 */
public class ThreadedServer {

    public static final int PORT = 19000;
    static Logger log = LoggerFactory.getLogger(ThreadedServer.class);
    private volatile boolean isRunning;
    private Map<Long, ConnectionHandler> handlers = new HashMap<>();
    private AtomicLong internalCounter = new AtomicLong(0);
    private ServerSocket sSocket;
    private Protocol protocol;
    private SessionManager sessionManager;
    private CommandHandler commandHandler;


    public ThreadedServer(Protocol protocol, SessionManager sessionManager, CommandHandler commandHandler) {
        try {
            this.protocol = protocol;
            this.sessionManager = sessionManager;
            this.commandHandler = commandHandler;
            sSocket = new ServerSocket(PORT);
            sSocket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Protocol protocol = new SerializationProtocol();
        //new JsonProtocol();//new StringProtocol();
        SessionManager sessionManager = new SessionManager();

        UserStore userStore = new UserDatabaseStore();
        MessageStore messageStore = new MessageDatabaseStore();
        //UserStore userStore = new UserStoreStub();
        //MessageStore messageStore = new MessageStoreStub();
        AuthorizationService authService = new AuthorizationService(userStore);

        Map<CommandType, Command> cmds = new HashMap<>();
        cmds.put(CommandType.USER_LOGIN, new LoginCommand(authService, sessionManager));
        cmds.put(CommandType.USER_INFO, new UserInfoCommand(userStore));
        cmds.put(CommandType.USER_PASS, new UserPassCommand(userStore));
        cmds.put(CommandType.CHAT_LIST, new ChatListCommand(messageStore));
        cmds.put(CommandType.CHAT_HISTORY, new ChatHistoryCommand(userStore, messageStore));
        cmds.put(CommandType.CHAT_FIND, new ChatFindCommand(userStore, messageStore));
        cmds.put(CommandType.CHAT_CREATE, new ChatCreateCommand(userStore, messageStore));
        cmds.put(CommandType.CHAT_SEND, new ChatSendCommand(sessionManager, userStore, messageStore));
        cmds.put(CommandType.USER_HELP, new HelpCommand(cmds));
        CommandHandler handler = new CommandHandler(cmds);


        ThreadedServer server = new ThreadedServer(protocol, sessionManager, handler);

        try {
            server.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startServer() throws Exception {
        log.info("Started, waiting for connection");

        isRunning = true;
        while (isRunning) {
            Socket socket = sSocket.accept();
            log.info("Accepted. " + socket.getInetAddress());

            ConnectionHandler handler = new SocketConnectionHandler(protocol, sessionManager.createSession(), socket);
            handler.addListener(commandHandler);

            handlers.put(internalCounter.incrementAndGet(), handler);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }

    public void stopServer() {
        isRunning = false;
        for (ConnectionHandler handler : handlers.values()) {
            handler.stop();
        }
    }
}

