package tech.immo.maintenance.utils;
import tech.immo.maintenance.models.Resource;
import tech.immo.maintenance.models.Role;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private int id;
    private String password;
    private String email;
    private Role roles;
    private Resource resource;
    private String firstName;
    private String lastName;

    public JwtResponse(String token, String refreshToken, int id, String password, String email, Role roles, Resource resource, String firstName, String lastName) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.id = id;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.resource = resource;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}