package ru.archetecture.hw11.net;

import ru.archetecture.hw11.message.Message;
import ru.archetecture.hw11.session.Session;

/**
 * Слушает сообщения
 */
public interface MessageListener {

    void onMessage(Session session, Message message);
}
