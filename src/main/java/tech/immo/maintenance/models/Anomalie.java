package tech.immo.maintenance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private Resource resource;
    private String description;
    private boolean isTreated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public Anomalie(int id, Resource resource, String description, boolean isTreated) {
        this.id = id;
        this.resource = resource;
        this.description = description;
        this.isTreated = isTreated;
        this.user = null;
    }

    public Anomalie(int id, Resource resource, String description,User user, boolean isTreated) {
        this.id = id;
        this.resource = resource;
        this.description = description;
        this.isTreated = isTreated;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public boolean isTreated() {
        return isTreated;
    }

    public void setTreated(boolean treated) {
        isTreated = treated;
    }

}
