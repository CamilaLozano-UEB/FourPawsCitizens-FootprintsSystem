package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Vet;

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
     * @param username     the username of the vet
     * @param name         vet's password
     * @param address      vet´s email
     * @param neighborhood vet's role
     * @return a result message
     */
    String modify(String username, String name, String address, String neighborhood);

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
