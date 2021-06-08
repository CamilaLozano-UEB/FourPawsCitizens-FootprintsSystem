package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.PetCase;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.CaseRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.CaseRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.petCases.CasePOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class CaseService {

    private CaseRepository caseRepository;
    private PetRepository petRepository;


    public String saveCase(CasePOJO casePOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        caseRepository = new CaseRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date create_at = null;
        try {
            create_at = format.parse(casePOJO.getCreated_at());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Optional<Pet> pet = petRepository.findById(casePOJO.getPet_id());
        if (!pet.isPresent()) return "El id de la mascota ingresado no existe";
        PetCase newcase = new PetCase(casePOJO.getCase_id(), create_at, casePOJO.getType(), casePOJO.getDescription(), pet.get());
        String message = caseRepository.save(newcase);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

}