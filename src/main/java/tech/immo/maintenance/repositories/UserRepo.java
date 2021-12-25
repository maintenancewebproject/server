package tech.immo.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.immo.maintenance.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    void deleteUserById(int id);

    Optional<User> findUserById(int id);
}
