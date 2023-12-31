package ru.archetecture.hw11.message;

import java.util.List;

/**
 * Хранилище информации о сообщениях
 */
public interface MessageStore {

    /**
    получаем список ид пользователей заданного чата
     */
    List<Long> getChatsByUserId(Long userId);

    /**
    получить информацию о чате
     */
    Chat getChatById(Long chatId);

    /**
     * Список сообщений из чата
     *
     */
    List<Long> getMessagesFromChat(Long chatId);

    /**
     * Получить информацию о сообщении
     */
    Message getMessageById(Long messageId);

    /**
     * Добавить сообщение в чат
     */
    boolean addMessage(Long chatId, Message message);

    /**
     * Добавить пользователя к чату
     */
    boolean addUserToChat(Long userId, Long chatId);

    /**
     * Создать чат
     */

    Chat createChat(List<Long> users);
}
