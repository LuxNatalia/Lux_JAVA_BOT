package org.telbot.telran.info.repository;
/** interface repository for user
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telbot.telran.info.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();
}
