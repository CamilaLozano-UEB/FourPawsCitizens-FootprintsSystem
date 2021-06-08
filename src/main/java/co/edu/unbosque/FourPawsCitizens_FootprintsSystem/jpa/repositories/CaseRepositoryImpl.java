package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.PetCase;

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
     * @param pPetCase the case to persist
     * @return a result message
     */
    @Override
    public String save(PetCase pPetCase) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pPetCase);
            entityManager.getTransaction().commit();
            return "se ha registrado correctamente";
        } catch (Exception e) {
            return "Ha ocurrido un error al registrar el caso!";
        }
    }

    /**
     * Finds all the petCases of the db
     *
     * @return a list of petCases
     */
    @Override
    public List<PetCase> findAll() {
        return entityManager.createQuery("from PetCase").getResultList();
    }
}
