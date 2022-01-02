package tech.immo.maintenance.services;

import org.springframework.stereotype.Service;
import tech.immo.maintenance.exceptions.AnomalieNotFoundException;
import tech.immo.maintenance.models.Anomalie;
import tech.immo.maintenance.models.Resource;
import tech.immo.maintenance.repositories.AnomalieRepo;

import java.util.List;
@Service
public class AnomalieService {

    private AnomalieRepo anomalieRepository;

    public AnomalieService(AnomalieRepo anomalieRepository) {

        this.anomalieRepository = anomalieRepository;
    }

    public void deleteAnomalie(int id) {
        anomalieRepository.deleteAnomalieById(id);
    }

    public void deleteAllAnomaliesByResource(Resource resource) {
        anomalieRepository.deleteAllAnomaliesByResource(resource);
    }

    public Anomalie addAnomalie(Anomalie anomalie) {
        return anomalieRepository.save(anomalie);

    }

    public Anomalie updateAnomalie(int id, boolean treated) {
        Anomalie anomalie = this.findAnomalieById(id);
        anomalie.setTreated(treated);
        return anomalieRepository.save(anomalie);
    }

    public List<Anomalie> findAllAnomaliesByResource(Resource resource) {
        return anomalieRepository.findAllAnomaliesByResource(resource);
    }

    public Anomalie findAnomalieById(int id) {
        return anomalieRepository.findAnomalieById(id)
                .orElseThrow(() ->
                        new AnomalieNotFoundException("l'anomalie' " +
                                id + "n'a pas été trouvée"));
    }
}
