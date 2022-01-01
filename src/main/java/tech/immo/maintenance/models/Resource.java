package tech.immo.maintenance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resource")
public class Resource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name= "resource_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    private String localisation;
    @OneToMany(mappedBy = "resource")
    private List<Anomalie> anomalies;
    private String description;

    public Resource() {
    }
    public Resource(int id, User user, String localisation, List<Anomalie> anomalies, String description) {
        this.id = id;
        this.user = user;
        this.localisation = localisation;
        this.anomalies = anomalies;
        this.description = description;
    }

    public Resource(int id, User user, String localisation, String description) {
        this.id = id;
        this.user = user;
        this.localisation = localisation;
        this.anomalies = new ArrayList<Anomalie>();
        this.description = description;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", user=" + user.getFirstName() + user.getLastName() +
                ", localisation='" + localisation + '\'' +
                ", description='" + description + '\'' +
                '}';
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

    public List<Anomalie> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(List<Anomalie> anomalies) {
        this.anomalies = anomalies;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
