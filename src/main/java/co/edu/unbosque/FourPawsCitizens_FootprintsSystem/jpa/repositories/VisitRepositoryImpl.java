package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Visit;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitRepositoryImpl implements VisitRepository {

    private EntityManager entityManager;

    public VisitRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * saves a new visit to the db
     *
     * @param visit the visit to save
     * @return a result message
     */
    @Override
    public String save(Visit visit) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(visit);
            entityManager.getTransaction().commit();
            return "se ha registrado correctamente";
        } catch (Exception e) {
            return "Ha ocurrido un error al registrar la visita!";
        }
    }

    /**
     * Finds all the visits of the db
     *
     * @return a list of visit
     */
    @Override
    public List<Visit> findAll() {
        return entityManager.createQuery("from Visit").getResultList();
    }

    /**
     * Finds the list of visits in a range of dates for a pet in a descending way
     *
     * @param date1   first date range
     * @param date2   second date range
     * @return a list of visits
     */
    @Override
    public List<Visit> findBetweenDatesByName(Date date1, Date date2) {
        return entityManager.
                createQuery("SELECT v FROM Visit v WHERE  v.createdAt BETWEEN : date1   AND : date2 ORDER BY v.createdAt DESC").
                setParameter("date1", date1).
                setParameter("date2", date2).
                getResultList();
    }
}
