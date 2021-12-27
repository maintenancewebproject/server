package tech.immo.maintenance.models;

import javax.persistence.*;

@Entity
@Table(name="anomalie")
public class Anomalie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name="anomalie_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
    private String description;
    private boolean isTreated;


    public Anomalie(int id, Resource resource, String description, boolean isTreated) {
        this.id = id;
        this.resource = resource;
        this.description = description;
        this.isTreated = isTreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
