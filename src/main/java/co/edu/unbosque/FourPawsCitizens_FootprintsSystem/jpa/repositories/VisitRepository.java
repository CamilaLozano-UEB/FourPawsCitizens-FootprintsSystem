package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Visit;

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

}
