package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Annotations to configure the entity, give a name and define the named queries
 */
@Entity
@Table(name = "Owner")
@PrimaryKeyJoinColumn
/**
 * Owner entity
 */
public class Owner extends UserApp {
    /**
     * Define the attributes for the Owner entity, the Id and the relations
     */
    @Id
    @Column(name = "username", unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private Integer person_id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "neighborhood")
    private String neighborhood;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();

    /**
     * @param username,     the owner's username
     * @param person_id,    the owner's person id
     * @param name,         the owner's name
     * @param address,      the owner's address
     * @param neighborhood, the owner's neighborhood
     */
    public Owner(String username, String password, String email, Integer person_id, String name, String address, String neighborhood) {
        super(username, password, email, "owner");
        this.username = username;
        this.person_id = person_id;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    public Owner() {
    }

    /**
     * add a pet to the list of pets
     *
     * @param pet, a new pet of the owner
     */
    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }

    /**
     * @return the owner's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username, the new owner's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the owner's person id
     */
    public Integer getPerson_id() {
        return person_id;
    }

    /**
     * @param person_id, the new owner's person id
     */
    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    /**
     * @return the owner's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name, the new owner's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the owner's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address, the new owner's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the owner's neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood, the new owner's neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the owner's pet list
     */
    public List<Pet> getPets() {
        return pets;
    }

    /**
     * @param pets the owner's pet list
     */
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

}
