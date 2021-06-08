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
     * @param pet_id the pet id
     * @return a list of visits
     */
    List<Visit> findBetweenDates(Date date1, Date date2, Integer pet_id);

}
