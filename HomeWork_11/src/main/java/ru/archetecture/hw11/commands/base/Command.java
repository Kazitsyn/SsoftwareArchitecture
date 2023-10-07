package ru.archetecture.hw11.commands.base;

import ru.archetecture.hw11.message.Message;
import ru.archetecture.hw11.session.Session;

/**
 * Абстрактный класс для всех команд
 * Цель абстрактного класса - переиспользование кода
 */

public abstract class Command {

    protected String name;
    protected String description;

    public abstract Message execute(Session session, Message message);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " " + description;
    }

}
