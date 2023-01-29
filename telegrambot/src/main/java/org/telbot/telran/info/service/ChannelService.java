package org.telbot.telran.info.service;
/** interface for channel
 * @author Natalia Lux
 * @version 1.0
 */
import org.telbot.telran.info.model.Channel;
import java.util.List;

public interface ChannelService {

    List<Channel> list();

    Channel create(Channel channel);

    Channel update(Channel channel);

    void delete(int id);

    Channel getChannel(int id);

    Channel create(String name, long channelId);
}
