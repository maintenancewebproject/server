package tech.immo.maintenance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.immo.maintenance.exceptions.UserNotFoundException;
import tech.immo.maintenance.models.User;
import tech.immo.maintenance.repositories.UserRepo;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserService(UserRepo userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void deleteUser(int id) {
        userRepository.deleteUserById(id);
    }


    public User addUser(User user) {
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(int id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("l'utilisateur " + id + "n'a pas été trouvé"));
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("l'utilisateur n'a pas été trouvé"));
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User doLogin(String password, String email) {
        User user = null;
        try {
            user = this.findUserByEmail(email);
        }catch(UserNotFoundException e) {
            return null;
        }
        if( passwordEncoder.matches(password, user.getPassWord())) {
            return user;
        }else {
            return null;
        }
    }


}