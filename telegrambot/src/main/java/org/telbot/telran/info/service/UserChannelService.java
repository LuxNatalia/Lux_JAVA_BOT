package org.telbot.telran.info.service;

import org.telbot.telran.info.model.Channel;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.model.UserChannel;

import java.util.List;
import java.util.Optional;
/** interface for user-channel subscription
 * @author Natalia Lux
 * @version 1.0
 */
public interface UserChannelService {

    List<UserChannel> list();

    List<UserChannel> listByUser(User user);

    List<UserChannel> listByChannel(Channel channel);

    UserChannel update(UserChannel userChannel);

    Optional<UserChannel> getUserChannel(int id);

    UserChannel addUserChannel(UserChannel userChannel);

    List<Channel> listChannelByUser(User user);

    UserChannel addUserChannel(User user, Channel channel);

    List<UserChannel> list(User user);

    void makeSubscriptionOn(int userChannelId);

    void makeSubscriptionOff(int userChannelId);

    List<UserChannel> getAllByActive();
}
