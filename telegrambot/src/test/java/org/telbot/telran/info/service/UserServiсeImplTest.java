package org.telbot.telran.info.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.repository.UserRepository;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class UserServiсeImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiсe userService;

    @BeforeEach
    void setUp(){
        userRepository.deleteAll();
    }

    @Test
    void createUserWithAllNonEmptyFields() {
        List<User> all=userRepository.findAll();
        assertEquals(0,all.size());
        User user = new User("UserFour");
        userService.create(user);
        List<User> all1=userRepository.findAll();
        assertEquals(1,all1.size());
        User userFromDataBase=all1.get(0);
        assertEquals(user.getId(), userFromDataBase.getId());
    }
}