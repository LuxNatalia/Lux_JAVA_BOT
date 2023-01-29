package org.telbot.telran.info.service;
/** class implements methods for messages
 *  @author Natalia Lux
 *  @version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.telbot.telran.info.model.Message;
import org.telbot.telran.info.repository.MessageRepository;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> list() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getAllNewMessages() {
        return messageRepository.findAllByUnread(true);
    }

    @Override
    public Message create(Message message) {
        Message messageEntity = messageRepository.save(new Message(message));
        return messageEntity;
    }

    @Override
    public Message create(String title, Long chatId, String text) {
        return messageRepository.save(new Message(title, chatId, text));
    }
}
