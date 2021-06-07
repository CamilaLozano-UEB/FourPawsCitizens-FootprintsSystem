package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

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
