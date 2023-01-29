package org.telbot.telran.info.controller;
/** class REST controller for messages
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telbot.telran.info.model.Message;
import org.telbot.telran.info.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> list() {
        List<Message> messages = messageService.list();
        return messages;
    }

    @PostMapping
    public Object create(Message message) {
        Object entity = messageService.create(message.getTitle(), message.getMessageId(), message.getText());
        return entity;
    }
}
