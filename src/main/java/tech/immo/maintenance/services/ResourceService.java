package tech.immo.maintenance.services;

import org.springframework.stereotype.Service;
import tech.immo.maintenance.exceptions.ResourceNotFoundException;
import tech.immo.maintenance.models.Resource;
import tech.immo.maintenance.models.User;
import tech.immo.maintenance.repositories.ResourceRepo;

import java.util.List;
@Service
public class ResourceService {
    private ResourceRepo resourceRepository;

    public ResourceService(ResourceRepo resourceRepo) {
        this.resourceRepository = resourceRepo;
    }

    public void deleteResource(int id) {
        resourceRepository.deleteUserById(id);
    }


    public Resource addResource(Resource resource) {
       return resourceRepository.save(resource);

    }

    public List<Resource> findAllResources(User user) {
        return resourceRepository.findAllByUser(user);
    }

    public Resource findResourceById(int id) {
        return resourceRepository.findResourceById(id)
                .orElseThrow(() -> new ResourceNotFoundException("la ressource " + id + "n'a pas été trouvée"));
    }

    public Resource updateResource(Resource resource) {
        return resourceRepository.save(resource);
    }
}
