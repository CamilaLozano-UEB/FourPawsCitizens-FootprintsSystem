package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities;

import javax.persistence.*;

/**
 * Annotations to configure the entity, give a name and define the named queries
 */
@Entity
@Table(name = "Official")
@PrimaryKeyJoinColumn
/**
 * Official entity
 */
public class Official extends UserApp {

    /**
     * Define the attributes for the Official entity, the Id and the relations
     */
    @Id
    @GeneratedValue
    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    /**
     * Void constructor
     */
    public Official() {
    }

    /**
     * @param username the official's username
     * @param password the official's password
     * @param email    the official's email
     * @param role     the official's role
     * @param name     the official's username
     */
    public Official(String username, String password, String email, String role, String name) {
        super(username, password, email, role);
        this.username = username;
        this.name = name;
    }

    /**
     * @return the official´s username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the new the official´s username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the official´s name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the new official´s name
     */
    public void setName(String name) {
        this.name = name;
    }

}