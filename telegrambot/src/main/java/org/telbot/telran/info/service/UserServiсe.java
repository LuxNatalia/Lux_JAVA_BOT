package org.telbot.telran.info.service;
/** interface for user
 * @author Natalia Lux
 * @version 1.0
 */
import org.telbot.telran.info.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiсe {

    List<User> list();

    User update(User user);

    void delete(int id);

    User create(User user);

    Optional<User> getUser(int id);

    User create(String name);
}
