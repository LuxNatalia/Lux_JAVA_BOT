package org.telbot.telran.info.repository;
/** interface repository for event
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.Event;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> getAllNewByUserId(Integer id);

}
