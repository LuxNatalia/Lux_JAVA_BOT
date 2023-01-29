package org.telbot.telran.info.service;
/** class implements methods for users
 *  @author Natalia Lux
 *  @version 1.0
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiсeImpl implements UserServiсe {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelService channelService;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        User userEntity = userRepository.findById(user.getId()).get();
        user.setName(user.getName() == null ? userEntity.getName() : user.getName());
        User entity = userRepository.save(user);
        return entity;
    }

    @Override
    public void delete(int id) {
        userRepository.deleteAllById(Collections.singleton(id));
    }

    @Override
    public User create(String name) {
        User entity = userRepository.save(new User(name));
        return entity;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
}
