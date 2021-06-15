package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.PetCase;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * Find the cases of a pet in a range of dates in a descending way
     *
     * @param date1  first date range
     * @param date2  second date range
     * @param pet_id the pet id
     * @return a list of cases
     */
    public List<PetCase> findBetweenDates(Date date1, Date date2, Integer pet_id) {
        Query petcaseq = entityManager.createQuery("SELECT c FROM PetCase c WHERE c.createdAt BETWEEN : date1   AND : date2 ORDER BY c.createdAt DESC");
        petcaseq.setParameter("date1", date1);
        petcaseq.setParameter("date2", date2);
        List<PetCase> petCaseList = petcaseq.getResultList();
        List<PetCase> petCases = new ArrayList<>();
        for (int i = 0; i < petCaseList.size(); i++) {
            if (petCaseList.get(i).getPet().getPet_id().equals(pet_id)) {
                petCases.add(petCaseList.get(i));
            }
        }
        return petCases;
    }
}
