package tech.immo.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.immo.maintenance.models.User;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    void deleteUserById(int id);

    //User findById(int id);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(int id);
}
