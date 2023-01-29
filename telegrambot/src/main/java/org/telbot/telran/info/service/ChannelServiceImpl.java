package org.telbot.telran.info.service;
/** class implements methods for channels
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.repository.ChannelRepository;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<Channel> list() {
        return channelRepository.findAll();
    }

    @Override
    public Channel create(Channel channel) {
        Channel entity = channelRepository.save(new Channel(channel));
        return entity;
    }

    @Override
    public Channel update(Channel channel) {
        Channel channelEntity = channelRepository.findById(channel.getId());
        channel.setName(channel.getName() == null ? channelEntity.getName() : channel.getName());
        Channel entity = channelRepository.save(channel);
        return entity;
    }

    @Override
    public void delete(int id) {
        if(id==0) {
            throw new IllegalArgumentException("Incorrect id " + id);
        }
        channelRepository.deleteById(id);
    }

    @Override
    public Channel getChannel(int id) {
        if(id==0) {
            throw new IllegalArgumentException("Incorrect id " + id);
        }
       Channel channel = channelRepository.findById(id);
        return channel;
    }

    @Override
    public Channel create(String name, long groupId) {
        Channel entity;
        entity = channelRepository.save(new Channel(name, groupId));
        return entity;
    }
}
