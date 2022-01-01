package tech.immo.maintenance.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name="user_id")
    private int id;
    private String firstName;
    private String lastName;
    private String passWord;
    @OneToMany(mappedBy = "user")
    private List<Resource> resource;
    @Column(unique = true)
    private String email;
   // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private int role;
    @OneToMany(mappedBy = "user")
    private List<Anomalie> anomalie;

    public User() {}

    public User(String firstName, List<Anomalie> anomalie, String lastName, String passWord, List<Resource> resource, String email, int role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.resource = resource;
        this.email = email;
        this.role = role;
        this.anomalie = anomalie;

    }

    public User(String firstName,List<Anomalie> anomalie, String lastName, String passWord, String email, int role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.resource = new ArrayList<Resource>();
        this.email = email;
        this.role = role;
        this.anomalie = anomalie;

    }

    public User(String firstName, String lastName, String passWord, List<Resource> resource, String email, int role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.resource = resource;
        this.email = email;
        this.role = role;
        this.anomalie = new ArrayList<Anomalie>();

    }

    public User(String firstName, String lastName, String passWord, String email, int role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.resource = new ArrayList<Resource>();
        this.email = email;
        this.role = role;
        this.anomalie = new ArrayList<Anomalie>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Anomalie> getAnomalie() {
        return anomalie;
    }

    public void setAnomalie(Anomalie anomalie) {
        this.anomalie.add(anomalie);
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public List<Resource> getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource.add(resource);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + lastName + firstName + '\'' +
                ", email ='" + email + '\'' +
                ", role ='" + role+ '\'' +
                '}';
    }

}
