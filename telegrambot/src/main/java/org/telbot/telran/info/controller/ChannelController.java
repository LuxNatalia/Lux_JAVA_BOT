package org.telbot.telran.info.controller;
/** class REST controller for channels
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.service.ChannelService;

import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping
    public List<Channel> list() {
        return channelService.list();
    }

    @PostMapping("/channel")
    public Channel create(String name, long channelId) {
        Channel entity = channelService.create(name, channelId);
        return entity;
    }

    @PutMapping
    public Channel update(Channel channel) {
        Channel channelEntity = channelService.update(channel);
        return channelEntity;
    }

    @DeleteMapping
    public void delete(int id) {
        try {
            channelService.delete(id);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage());
        }
    }

    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable int id) {
        try {
            return channelService.getChannel(id);
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage());
        }
    }
}
