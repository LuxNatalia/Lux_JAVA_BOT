package org.telbot.telran.info.repository;
/** interface repository for message
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findAll();

    List<Message> findAllByUnread(boolean b);
}
