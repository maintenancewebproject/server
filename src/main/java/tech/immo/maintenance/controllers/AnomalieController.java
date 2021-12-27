package tech.immo.maintenance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.immo.maintenance.models.Anomalie;
import tech.immo.maintenance.models.Resource;
import tech.immo.maintenance.services.AnomalieService;

import java.util.List;

@RestController
@RequestMapping("/anomalie")
public class AnomalieController {
    private AnomalieService anomalieService;

    public AnomalieController(AnomalieService anomalieService) {
        this.anomalieService = anomalieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Anomalie>> getAllAnomaliesByResource(@RequestBody Resource resource) {
        List<Anomalie> anomalies = anomalieService.findAllAnomaliesByResource(resource);
        return new ResponseEntity<>(anomalies, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Anomalie> getAnomalieById (@PathVariable("id") int id) {
        Anomalie anomalie = anomalieService.findAnomalieById(id);
        return new ResponseEntity<>(anomalie, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Anomalie> addAnomalie(@RequestBody Anomalie anomalieData) {
        Anomalie anomalie = anomalieService.addAnomalie(anomalieData);
        return new ResponseEntity<>(anomalie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnomalie(@PathVariable int id) {
        anomalieService.deleteAnomalie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllAnomaliesByResource(@PathVariable Resource resource) {
        anomalieService.deleteAllAnomaliesByResource(resource);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
