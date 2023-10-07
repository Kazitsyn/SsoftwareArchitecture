package ru.archetecture.hw11.net;

import java.io.IOException;

import ru.archetecture.hw11.message.Message;

/**
 * Обработчик сокета
 */
public interface ConnectionHandler extends Runnable {

    void send(Message msg) throws IOException;

    void addListener(MessageListener listener);

    void stop();
}
