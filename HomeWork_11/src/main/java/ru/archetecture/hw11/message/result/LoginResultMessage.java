package ru.archetecture.hw11.message.result;

import ru.archetecture.hw11.commands.base.CommandType;
import ru.archetecture.hw11.message.Message;

public class LoginResultMessage extends Message {
    private String login;
    private String pass;
    private Long userId;

    public LoginResultMessage() {
        setType(CommandType.LOGIN_RESULT);
    }

    public LoginResultMessage(String login, Long userId) {
        this();
        this.login = login;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "LoginResultMessage{" +
                "login='" + login + '\'' +
                ", userId=" + userId +
                "} " + super.toString();
    }
}