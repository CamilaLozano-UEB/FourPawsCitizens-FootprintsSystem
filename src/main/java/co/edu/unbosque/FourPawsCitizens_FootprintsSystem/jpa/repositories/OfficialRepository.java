package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    /**
     * saves a new official to the db
     *
     * @param official the case to persist
     * @return a result message
     */
    String save(Official official);

    /**
     * Modify the attributes of an specific official
     *
     * @param officialPojo the new data of owner in the db
     * @return a message of the result
     */
    String modify(OfficialPOJO officialPojo);

    /**
     * Delete an official from the DB
     *
     * @param official the official to delete
     */
    void delete(Official official);

    /**
     * Find an official by id
     *
     * @param username official's id
     * @return an optional object of official
     */
    Optional<Official> findById(String username);

    /**
     * Finds all the officials of the db
     *
     * @return a list of officials
     */
    List<Official> findAll();
}
