package org.telbot.telran.info.controller;
/** class REST controller for users
 * @author Natalia Lux
 * @version 1.0
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telbot.telran.info.model.User;
import org.telbot.telran.info.service.UserServiсe;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tgUsers")
public class UserController {

    @Autowired
    private UserServiсe userService;

    @GetMapping
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUser(@PathVariable(name = "userId") int id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public User update(User user) {
        User userEntity = userService.update(user);
        return userEntity;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(name = "userId") int id) {
        userService.delete(id);
    }
}
