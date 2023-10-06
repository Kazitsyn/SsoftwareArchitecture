package serialization;


import message.Message;

/**
 *
 */
public interface Protocol {

    byte[] encode(Message msg) throws ProtocolException;

    Message decode(byte[] data) throws ProtocolException;
}
