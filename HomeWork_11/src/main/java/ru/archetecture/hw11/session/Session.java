package ru.archetecture.hw11.session;

import ru.archetecture.hw11.message.User;
import ru.archetecture.hw11.net.ConnectionHandler;

/**
 * Класс содержит информацию о текущей сессии взаимодействия
 * Пока нам остаточно хранить юзера, возможно понадобится еще какое-то состояние
 */
public class Session {

    private Long id;
    private User sessionUser;
    private ConnectionHandler connectionHandler;

    public Session() {
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public void setConnectionHandler(ConnectionHandler connectionHandler) {
        this.connectionHandler = connectionHandler;
    }

    public Session(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", sessionUser=" + sessionUser +
                ", connectionHandler=" + connectionHandler +
                '}';
    }
}
