package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    /**
     * saves a new pet to the db
     *
     * @param pet the pet to be saved
     * @return a result message
     */
    String save(Pet pet);

    /**
     * Finds all the pets of the db
     *
     * @return a list of pets
     */
    List<Pet> findAll();

    /**
     * Modify the attributes of an specific pet
     *
     * @param petPOJO the pet with the new data
     * @return a result message
     */
    String modify(PetPOJO petPOJO);
    /**
     * Modify the microchip of an specific pet
     *
     * @param petPOJO the pet with the new data
     * @return a result message
     */
    String modifyForVisit(PetPOJO petPOJO);
    /**
     * Finds a pet by id on the db
     *
     * @param petId the pet id to find
     * @return an Optional of pet
     */
    Optional<Pet> findById(Integer petId);
}
