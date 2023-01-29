package org.telbot.telran.info.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.repository.ChannelRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class ChannelServiceImplTest {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private ChannelService channelService;

    @BeforeEach
    void setUp(){
        channelRepository.deleteAll();
    }

    @Test
    void createChannelWithAllNonEmptyFields() {
        List<Channel> all=channelRepository.findAll();
        assertEquals(0,all.size());
        Channel channel = new Channel("ChannelOne", 111);
        channelService.create(channel);
        List<Channel> all1=channelRepository.findAll();
        assertEquals(1,all1.size());
        Channel channelFromDataBase=all1.get(0);
        assertEquals(channel.getId(), channelFromDataBase.getId());
    }
  }