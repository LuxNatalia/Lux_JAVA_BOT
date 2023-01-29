package org.telbot.telran.info.service;
/** interface for message
 * @author Natalia Lux
 * @version 1.0
 */
import org.telbot.telran.info.model.Message;

import java.util.List;

public interface MessageService {

    Message create(Message message);

    Message create(String title, Long messageId, String text);

    List<Message> list();

    List<Message> getAllNewMessages();

}
