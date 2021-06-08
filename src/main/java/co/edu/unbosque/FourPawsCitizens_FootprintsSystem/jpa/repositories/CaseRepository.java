package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.PetCase;

import java.util.List;

public interface CaseRepository {

    /**
     * saves a new case to the db
     *
     * @param pPetCase the case to persist
     * @return a result message
     */
    String save(PetCase pPetCase);

    /**
     * Finds all the cases of the db
     *
     * @return a list of cases
     */
    List<PetCase> findAll();

}
