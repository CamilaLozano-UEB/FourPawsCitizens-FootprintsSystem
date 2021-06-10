package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Vet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.vet.VetPOJO;

import java.util.List;
import java.util.Optional;

public interface VetRepository {

    /**
     * saves a new vet to the db
     *
     * @param vet the case to persist
     * @return a result message
     */
    String save(Vet vet);

    /**
     * Modify the attributes of an specific vet
     *
     * @param vetPojo the data of pet in the db
     * @return a result message
     */
    String modify(VetPOJO vetPojo);

    /**
     * Delete an vet from the DB
     *
     * @param vet the user to delete
     */
    void delete(Vet vet);

    /**
     * Find a vet by id
     *
     * @param username vet's id
     * @return an optional object of vet
     */
    Optional<Vet> findById(String username);

    /**
     * Finds all the vets of the db
     *
     * @return a list of vets
     */
    List<Vet> findAll();
}
