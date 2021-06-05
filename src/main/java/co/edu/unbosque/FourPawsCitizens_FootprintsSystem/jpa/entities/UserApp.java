package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities;

import javax.persistence.*;

/**
 * Annotations to configure the entity, give a name and define the named queries
 */
@Entity
@Table(name = "UserApp")
@NamedQueries({
        @NamedQuery(name = "UserApp.findAll",
                query = "SELECT u FROM UserApp u")
})
/**
 * UserApp entity
 */
public class UserApp {

    /**
     * Define the attributes for the UserApp entity, the Id and the relations
     */
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;

    /**
     * Void Constructor
     */
    public UserApp() {
    }

    /**
     * @param username the user app's username
     * @param password the user app's password
     * @param email    the user app's email
     * @param role     the user app's role
     */
    public UserApp(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /**
     * @return the user app's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the new user app's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the user app's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the new user app's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the user app's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the new user app's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the user app's role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the new user app's role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
