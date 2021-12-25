package tech.immo.maintenance.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;
    private String firstName;
    private String lastName;
    private String passWord;
    private String email;
    private int role;

    public User() {}

    public User(String firstName,String lastName,String passWord, String email, int role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
        this.email = email;
        this.role = role;

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + lastName + firstName + '\'' +
                ", email ='" + email + '\'' +
                ", role ='" + role + '\'' +
                '}';
    }

}
