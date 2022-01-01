package tech.immo.maintenance.models;

import javax.persistence.*;

@Entity
public enum Role {
    Administrateur(1, "Administrateur"),
    Responsable(2, "Responsable"),
    Usager(3, "Usager");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    //@OneToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "id")
   // private User user;

    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
}
