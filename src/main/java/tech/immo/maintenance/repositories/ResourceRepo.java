package tech.immo.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.immo.maintenance.models.Resource;
import tech.immo.maintenance.models.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface ResourceRepo extends JpaRepository<Resource, Integer> {

    List<Resource> findAllByUser(User user);

    Optional<Resource> findResourceById(int id);

    List<Resource> findAllResourcesByUserId(int id);

    void deleteResourceById(int id);
}
