package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Annotations to configure the entity, give a name and define the named queries
 */
@Entity
@Table(name = "Vet")
@PrimaryKeyJoinColumn
/**
 * Vet entity
 */
public class Vet extends UserApp {
    /**
     * Define the attributes for the Vet entity, the Id and the relations
     */
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;

    @OneToMany(mappedBy = "vet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Visit> visits = new ArrayList<>();

    /**
     * @param username,     the owner's username
     * @param name,         the owner's name
     * @param address,      the owner's address
     * @param neighborhood, the owner's neighborhood
     */
    public Vet(String username, String password, String email, String name, String address, String neighborhood) {
        super(username, password, email, "vet");
        this.username = username;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    /**
     * Void constructor
     */
    public Vet() {
    }

    public void addVisit(Visit visit) {
        this.visits.add(visit);
    }

    /**
     * @return the vet's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the new vet's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the vet's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the new vet's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the vet's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the new vet's name
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the vet's neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the new vet's neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the list of visits
     */
    public List<Visit> getVisits() {
        return visits;
    }

    /**
     * @param visits the new list of visits
     */
    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}