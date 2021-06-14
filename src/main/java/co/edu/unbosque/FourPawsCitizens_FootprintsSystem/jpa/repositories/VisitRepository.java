package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Visit;

import java.util.Date;
import java.util.List;

public interface VisitRepository {

    /**
     * saves a new visit to the db
     *
     * @param visit the visit to save
     * @return a result message
     */
    String save(Visit visit);

    /**
     * Finds all the visits of the db
     *
     * @return a list of visit
     */
    List<Visit> findAll();

    /**
     *  Finds the list of visits in a range of dates for a pet in a descending way
     *
     * @param date1 first date range
     * @param date2 second date range
     * @return a list of visits
     */
    List<Visit> findBetweenDatesByPetId(Date date1, Date date2, Integer petId);
    /**
     *  Finds the list of visits in a range of dates for a pet in a descending way
     *
     * @param date1 first date range
     * @param date2 second date range
     * @return a list of visits
     */
    List<Visit> findBetweenDatesByName(Date date1, Date date2);
}
