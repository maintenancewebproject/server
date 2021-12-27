package tech.immo.maintenance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.immo.maintenance.models.Anomalie;
import tech.immo.maintenance.models.Resource;

import java.util.List;
import java.util.Optional;
@Repository
public interface AnomalieRepo extends JpaRepository<Anomalie, Integer> {

    void deleteAnomalieById(int id);

    void deleteAllAnomaliesByResource(Resource resource);

    List<Anomalie> findAllAnomaliesByResource(Resource resource);

    Optional<Anomalie> findAnomalieById(int id);
}
