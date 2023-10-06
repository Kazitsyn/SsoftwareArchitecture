package message.result;

import commands.base.CommandType;
import message.Message;
import message.User;


public class UserInfoResultMessage extends Message {
    private User user;

    public UserInfoResultMessage() {
        setType(CommandType.USER_INFO_RESULT);
    }

    public UserInfoResultMessage(User user) {
        this();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfoResultMessage{" +
                "user=" + user +
                "} " + super.toString();
    }
}