package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.PetCase;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.CaseRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.CaseRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.cases.CasePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CaseService {

    private CaseRepository caseRepository;
    private PetRepository petRepository;

    /**
     * Method that save a new casePojo object
     *
     * @param casePOJO case's pojo
     * @return a string message
     */
    public String saveCase(CasePOJO casePOJO) {
        //Creating a entity manager factory for the db
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //Initialing the repositories
        caseRepository = new CaseRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        //Passing String to date
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date create_at = null;
        //Validating the date
        try {
            create_at = format.parse(casePOJO.getCreated_at());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Creating a optional object pet, if exists the case is created.
        Optional<Pet> pet = petRepository.findById(casePOJO.getPet_id());
        if (!pet.isPresent()) return "El id de la mascota ingresado no existe";
        PetCase newcase = new PetCase(casePOJO.getCase_id(), create_at, casePOJO.getType(), casePOJO.getDescription(), pet.get());
        String message = caseRepository.save(newcase);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

    /**
     * Find the cases of a pet in a range of dates in a descending way
     *
     * @param date1  first date range
     * @param date2  second date range
     * @param pet_id the pet id
     * @return a list of casesPOJO
     */
    public List<CasePOJO> findCasesBetweenDatesByPet(Date date1, Date date2, Integer pet_id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        caseRepository = new CaseRepositoryImpl(entityManager);
        List<PetCase> petCases;
        if (date1.before(date2)) {
            petCases = caseRepository.findBetweenDates(date1, date2, pet_id);
        } else {
            petCases = caseRepository.findBetweenDates(date2, date1, pet_id);
        }
        List<CasePOJO> casePOJOS = new ArrayList<>();
        petCases.forEach(c -> {
            casePOJOS.add(new CasePOJO(c.getCaseId(),
                    new SimpleDateFormat("dd/MM/yyyy").format(c.getCreatedAt()),
                    c.getType(),
                    c.getDescription(),
                    c.getPet().getPet_id()));
        });

        return casePOJOS;
    }
}