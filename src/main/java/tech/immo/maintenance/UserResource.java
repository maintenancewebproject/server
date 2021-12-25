package tech.immo.maintenance;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.immo.maintenance.model.User;
import tech.immo.maintenance.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") int id) {
        User user= userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<User> addUser(@RequestBody User userData) {
        User user = userService.addUser(userData);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<User> updateUser(@RequestBody User userData) {
        User user = userService.updateUser(userData);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
