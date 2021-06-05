package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Case;

import javax.persistence.EntityManager;
import java.util.List;

public class CaseRepositoryImpl implements CaseRepository {

    private EntityManager entityManager;

    public CaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * saves a new case to the db
     *
     * @param pCase the case to persist
     * @return a result message
     */
    @Override
    public String save(Case pCase) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pCase);
            entityManager.getTransaction().commit();
            return "se ha registrado correctamente";
        } catch (Exception e) {
            return "Ha ocurrido un error al registrar el caso!";
        }
    }

    /**
     * Finds all the cases of the db
     *
     * @return a list of cases
     */
    @Override
    public List<Case> findAll() {
        return entityManager.createQuery("from Case").getResultList();
    }
}
