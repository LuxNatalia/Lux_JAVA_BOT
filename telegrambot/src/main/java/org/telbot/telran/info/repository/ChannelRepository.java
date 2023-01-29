package org.telbot.telran.info.repository;
/** interface repository for channel
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.Channel;
import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

    List<Channel> findAll();

    List<Channel> findAllById(List<Long> channelIds);

    Channel findById(int id);

}
