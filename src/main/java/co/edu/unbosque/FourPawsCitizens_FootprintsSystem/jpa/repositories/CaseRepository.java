package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.PetCase;

import java.util.Date;
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

    /**
     * Find the cases of a pet in a range of dates
     *
     * @param date1 first date range
     * @param date2 second date range
     * @param pet_id the pet id
     * @return a list of cases
     */
    List<PetCase> findBetweenDates(Date date1, Date date2, Integer pet_id);

}
