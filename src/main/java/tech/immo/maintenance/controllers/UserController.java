package tech.immo.maintenance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.immo.maintenance.models.LoginForm;
import tech.immo.maintenance.models.User;
import tech.immo.maintenance.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
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
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("login")
    public ResponseEntity<User> doLogin(@RequestBody LoginForm userData) {
        User user = userService.doLogin(userData.getPassWord(), userData.getUserName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
