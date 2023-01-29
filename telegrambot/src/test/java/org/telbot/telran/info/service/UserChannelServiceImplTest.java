package org.telbot.telran.info.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.repository.UserChannelRepository;
import org.telbot.telran.info.repository.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UserChannelServiceImplTest {

    @Autowired
    private UserChannelRepository userChannelRepository;

    @Autowired
    private UserChannelService userChannelService;

    @BeforeEach
    void setUp(){
        userChannelRepository.deleteAll();
    }

    @Test
    void makeSubscriptionOffFromOn(int userChannelId) {
        List<UserChannel> all=userChannelRepository.findAll();
        assertEquals(0,all.size());
        UserChannel userChannel = new UserChannel(1,1);
        userChannel.setActive(true);
        userChannelService.addUserChannel(userChannel);
        userChannelService.makeSubscriptionOff(0);
        List<UserChannel> all1=userChannelRepository.findAll();
        assertEquals(1,all1.size());
        UserChannel userChannelFromDataBase=all1.get(0);
        assertEquals(userChannelFromDataBase.isActive(), false);
    }
}