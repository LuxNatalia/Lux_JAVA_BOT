package org.telbot.telran.info.service;
/** interface for event
 * @author Natalia Lux
 * @version 1.0
 */
import org.telbot.telran.info.model.Event;
import org.telbot.telran.info.model.User;

import java.util.List;

public interface EventService {

    void getAllNewMessages();

    void createNewEvents();

    List<Event> getNewEventsByUser(User user);

    List<Event> list();
}
