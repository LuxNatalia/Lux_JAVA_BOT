package org.telbot.telran.info.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telbot.telran.info.model.Message;
import org.telbot.telran.info.repository.MessageRepository;
import org.telbot.telran.info.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class MessageServiceImplTest {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    @BeforeEach
    void setUp(){
        messageRepository.deleteAll();
    }

    @Test
    void createMessageWithAllNonEmptyFields() {
        List<Message> all = messageRepository.findAll();
        assertEquals(0,all.size());
        Message message = new Message("ChannelTwo", 222222L, "hohohohohohoho");
        messageService.create(message);
        List<Message> all1=messageRepository.findAll();
        assertEquals(1,all1.size());
        Message messageFromDataBase=all1.get(0);
        assertEquals(message.getMessageId(), messageFromDataBase.getMessageId());
    }
}