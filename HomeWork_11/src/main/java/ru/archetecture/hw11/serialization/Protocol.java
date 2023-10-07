package ru.archetecture.hw11.serialization;


import ru.archetecture.hw11.message.Message;

/**
 *
 */
public interface Protocol {

    byte[] encode(Message msg) throws ProtocolException;

    Message decode(byte[] data) throws ProtocolException;
}
