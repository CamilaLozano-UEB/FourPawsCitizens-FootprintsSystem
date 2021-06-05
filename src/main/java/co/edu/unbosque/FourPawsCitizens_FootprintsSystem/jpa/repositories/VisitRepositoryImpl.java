package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Visit;

import javax.persistence.EntityManager;
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
}
