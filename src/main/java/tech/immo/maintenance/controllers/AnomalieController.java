package tech.immo.maintenance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.immo.maintenance.models.Anomalie;
import tech.immo.maintenance.models.Resource;
import tech.immo.maintenance.models.User;
import tech.immo.maintenance.services.AnomalieService;
import tech.immo.maintenance.services.ResourceService;
import tech.immo.maintenance.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/anomalie")
public class AnomalieController {
    private AnomalieService anomalieService;
    private UserService userService;
    private ResourceService resourceService;

    public AnomalieController(AnomalieService anomalieService, UserService userService, ResourceService resourceService) {
        this.anomalieService = anomalieService;
        this.userService = userService;
        this.resourceService = resourceService;
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<Anomalie>> getAllAnomaliesByResource(@PathVariable("id") int id) {
        Resource resource = resourceService.findResourceById(id);
        List<Anomalie> anomalies = anomalieService.findAllAnomaliesByResource(resource);
        return new ResponseEntity<>(anomalies, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Anomalie> getAnomalieById (@PathVariable("id") int id) {
        Anomalie anomalie = anomalieService.findAnomalieById(id);
        return new ResponseEntity<>(anomalie, HttpStatus.OK);
    }

    @PostMapping("add/{resourceId}/{userId}")
    public ResponseEntity<Anomalie> addAnomalie(@RequestBody Anomalie anomalieData, @PathVariable("resourceId") int resourceId, @PathVariable("userId") int userId) {
        if(userId != 0 ) {
            User user = userService.findUserById(userId);
            anomalieData.setUser(user);
        }
        Resource resource = resourceService.findResourceById(resourceId);
        anomalieData.setResource(resource);
        Anomalie anomalie = anomalieService.addAnomalie(anomalieData);
        return new ResponseEntity<>(anomalie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnomalie(@PathVariable int id) {
        anomalieService.deleteAnomalie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllAnomaliesByResource(@RequestBody Resource resource) {
        anomalieService.deleteAllAnomaliesByResource(resource);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update/{id}/{treated}")
    public ResponseEntity<Anomalie> updateAnomalie(@PathVariable("id") int id, @PathVariable("treated") boolean treated) {
        Anomalie anomalie = anomalieService.updateAnomalie(id, treated);
        return new ResponseEntity<>(anomalie, HttpStatus.OK);
    }
}
