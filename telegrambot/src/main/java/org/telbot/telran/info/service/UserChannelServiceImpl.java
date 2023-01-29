package org.telbot.telran.info.service;
/** class implements methods for user-channel subscriptions
 *  @author Natalia Lux
 *  @version 1.0
 */
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;
import org.telbot.telran.info.repository.ChannelRepository;
import org.telbot.telran.info.repository.UserChannelRepository;
import org.telbot.telran.info.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserChannelServiceImpl implements UserChannelService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserChannelRepository userChannelRepository;

    @Override
    public List<UserChannel> list() {
        return userChannelRepository.findAll();
    }

    @Override
    public List<UserChannel> listByUser(User user) {
        return userChannelRepository.findAllByUserId(user.getId());
    }

    @Override
    public List<UserChannel> listByChannel(Channel channel) {
        return userChannelRepository.findAllByChannelId(channel.getId());
    }

    @Override
    public UserChannel update(UserChannel userChannel) {
        UserChannel userChannelEntity = (UserChannel) userChannelRepository.findById(userChannel.getId());
        userChannel.setIsOn(userChannel.getIsOn());
        UserChannel entity=userChannelRepository.save(userChannel);
        return entity;
    }

    @Override
    public Optional<UserChannel> getUserChannel(int id) {
        UserChannel userChannel = (UserChannel) userChannelRepository.findById(id);
        return Optional.ofNullable(userChannel);
    }

    @Override
    public UserChannel addUserChannel(UserChannel userChannel) {
        UserChannel entity = userChannelRepository.save(new UserChannel(userChannel));
        return entity;
    }

    @Override
    public UserChannel addUserChannel(User user, Channel channel) {
        return userChannelRepository.save((new UserChannel(user.getId(), channel.getId())));
    }

    @Override
    public List<UserChannel> list(User user) {
        return userChannelRepository.findAllByUserId(user.getId());
    }

    @Override
    public void makeSubscriptionOn(int userChannelId) {
        UserChannel userChannelEntity = userChannelRepository.findById(userChannelId).stream().findFirst().get();
        userChannelEntity.setIsOn(true);
        userChannelRepository.save(userChannelEntity);
    }

    @Override
    public void makeSubscriptionOff(int userChannelId) {
        UserChannel userChannelEntity = userChannelRepository.findById(userChannelId).stream().findFirst().get();
        userChannelEntity.setIsOn(false);
        userChannelRepository.save(userChannelEntity);
    }

    @Override
    public List<UserChannel> getAllByActive() {
        return userChannelRepository.findAllByActive(true);
    }

    @Override
    public List<Channel> listChannelByUser(User user) {
        List<Long> channelIds = userChannelRepository.findAllByUserId(user.getId()).stream().map(
                UserChannel::getGroupId).collect(Collectors.toList());
        return channelRepository.findAllById(channelIds);
    }
}


