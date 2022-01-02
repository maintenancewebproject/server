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
        resourceRepository.deleteById(id);
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

    public Resource updateResource(Resource resourceData) {
        Resource resource = this.findResourceById(resourceData.getId());
        resource.setLocalisation(resourceData.getLocalisation());
        resource.setDescription(resourceData.getDescription());
        //resourceRepository.deleteById(resourceData.getId());
        resourceRepository.save(resource);
        return resource;
    }

    public List<Resource> findAllResourcesByUserId(User user) {
         return resourceRepository.findAllResourcesByUserId(user.getId());
    }
}
