package tech.immo.maintenance.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.immo.maintenance.models.Resource;
import tech.immo.maintenance.models.User;
import tech.immo.maintenance.services.ResourceService;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Resource>> getAllResourcesByUser (@RequestBody User user) {
        List<Resource> resources = resourceService.findAllResources(user);
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Resource> getResourceById (@PathVariable("id") int id) {
        Resource resource= resourceService.findResourceById(id);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Resource> addResource(@RequestBody Resource resourceData) {
        Resource resource = resourceService.addResource(resourceData);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Resource> updateResource(@RequestBody Resource resourceData) {
        Resource resource = resourceService.updateResource(resourceData);
        return new ResponseEntity<>(resource, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable int id) {
        resourceService.deleteResource(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
