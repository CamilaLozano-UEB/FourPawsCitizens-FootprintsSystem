package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;

import java.util.ArrayList;
import java.util.List;

public class OwnerPOJO {

    private String username;
    private Integer person_id;
    private String name;
    private String address;
    private String neighborhood;
    private List<PetPOJO> pets =new ArrayList<PetPOJO>();


    public OwnerPOJO() {

    }

    /**
     * @param username,     the owner's username
     * @param person_id,    the owner's person id
     * @param name,         the owner's name
     * @param address,      the owner's address
     * @param neighborhood, the owner's neighborhood
     */
    public OwnerPOJO(String username, Integer person_id, String name, String address, String neighborhood) {
        this.username = username;
        this.person_id = person_id;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    /**
     *
     * @return List of pets
     */
    public List<PetPOJO> getPets() {
        return pets;
    }

    /**
     *
     * @param pets List of pets
     */
    public void setPets(List<PetPOJO> pets) {
        this.pets = pets;
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
     * add a pet to the list of pets
     * @param pet, a new pet of the owner
     */
    public void addPets(PetPOJO pet) {
        pets.add(pet);
    }

}

