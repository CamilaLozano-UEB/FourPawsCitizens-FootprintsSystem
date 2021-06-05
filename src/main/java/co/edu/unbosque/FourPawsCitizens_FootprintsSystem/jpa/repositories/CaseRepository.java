package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Case;

import java.util.List;

public interface CaseRepository {

    /**
     * saves a new case to the db
     *
     * @param pCase the case to persist
     * @return a result message
     */
    String save(Case pCase);

    /**
     * Finds all the cases of the db
     *
     * @return a list of cases
     */
    List<Case> findAll();

}
