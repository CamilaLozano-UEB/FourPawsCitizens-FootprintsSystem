package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Annotations to configure the entity, give a name and define the named queries
 */
@Entity
@Table(name = "Official")
@NamedQueries({
        @NamedQuery(name = "Official.findAll",
                query = "SELECT of FROM Official of")
})
/**
 * Official entity
 */
public class Official {

    /**
     * Define the attributes for the Official entity, the Id and the relations
     */
    @Id
    @GeneratedValue
    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "official", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();
    @OneToMany(mappedBy = "official", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Owner> owners = new ArrayList<>();
    @OneToMany(mappedBy = "official", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Case> cases = new ArrayList<>();

    /**
     * Void constructor
     */
    public Official() {
    }

    /**
     * @param username the official's username
     * @param name     the official's username
     */
    public Official(String username, String name) {
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

    /**
     * @return the lists of pets
     */
    public List<Pet> getPets() {
        return pets;
    }

    /**
     * @param pets the new list of pets
     */
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    /**
     * @return the list of owners
     */
    public List<Owner> getOwners() {
        return owners;
    }

    /**
     * @param owners the new list of owners
     */
    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    /**
     * @return the list of cases
     */
    public List<Case> getCases() {
        return cases;
    }

    /**
     * @param cases the new list of cases
     */
    public void setCases(List<Case> cases) {
        this.cases = cases;
    }
}