package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Vet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Visit;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.*;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit.VisitPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class VisitService {
    private PetRepository petRepository;
    private VetRepository vetRepository;

    /**
     * @param visitPOJO visit's pojo
     * @return a string message
     */
    public String saveVisit(VisitPOJO visitPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);
        vetRepository = new VetRepositoryImpl(entityManager);

        // Creating an optional pet object and find the id of the pet in the visit's pojo
        Optional<Pet> petO = petRepository.findById(visitPOJO.getPet_id());

        //If the id doesn't exist return false

        if (!petO.isPresent()) return "No existe esa identificación de mascota";

        // Creating an optional vet object and find the id of the vet in the visit's pojo
        Optional<Vet> vetO = vetRepository.findById(visitPOJO.getVetUsername());

        //If the id doesn't exist return false
        if (!vetO.isPresent()) return "No existe esa veterinaria";

        Pet pet = petRepository.findById(visitPOJO.getPet_id()).get();

        Vet vet = vetRepository.findById(visitPOJO.getVetUsername()).get();

        //Validating the format of the date, passing date of string to date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date createdAt;
        try {
            createdAt = format.parse(visitPOJO.getCreated_at());
        } catch (ParseException e) {
            return "El formato de la fecha es incorrecto!";
        }

        //Creating the visit and save it in the repository
        Visit visit = new Visit(createdAt, visitPOJO.getType(), visitPOJO.getDescription(), vet, pet);

        pet.addVisit(visit);
        petRepository.save(pet);

        vet.addVisit(visit);
        vetRepository.save(vet);

        entityManager.close();
        entityManagerFactory.close();
        return "Se ha creado exitosamente la visita!";
    }

    /**
     * Method that verify the existence of a visit in the db
     *
     * @param visitPOJO visit's pojo
     * @return a boolean value
     */
    public boolean verifyMicrochipVisit(VisitPOJO visitPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        vetRepository = new VetRepositoryImpl(entityManager);

        // Creating an optional pet object and find the id of the pet in the visit's pojo
        Optional<Pet> pet = petRepository.findById(visitPOJO.getPet_id());

        //If the id doesn't exist return false
        if (!pet.isPresent()) return false;

        // Creating an optional vet object and find the id of the vet in the visit's pojo
        Optional<Vet> vet = vetRepository.findById(visitPOJO.getVetUsername());

        //If the id doesn't exist return false
        if (!vet.isPresent()) return false;

        return pet.get().getMicrochip() == null;
    }

    /**
     * Method that verify the existence of a visit in the db
     *
     * @param visitPOJO visit's pojo
     * @return a boolean value
     */
    public boolean verifySterilizationVisit(VisitPOJO visitPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        vetRepository = new VetRepositoryImpl(entityManager);

        // Creating an optional pet object and find the id of the pet in the visit's pojo
        Optional<Pet> pet = petRepository.findById(visitPOJO.getPet_id());

        //If the id doesn't exist return false

        if (!pet.isPresent()) return false;

        // Creating an optional vet object and find the id of the vet in the visit's pojo
        Optional<Vet> vet = vetRepository.findById(visitPOJO.getVetUsername());

        //If the id doesn't exist return false
        if (!vet.isPresent()) return false;

        Set<Visit> visits = pet.get().getVisits();

        for (Visit visit : visits)
            if (visit.getType().equals("Esterilización")) return false;

        return true;
    }

}
