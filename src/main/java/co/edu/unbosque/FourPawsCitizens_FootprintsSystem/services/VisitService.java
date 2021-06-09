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
    private VisitRepository visitRepository;
    private PetRepository petRepository;
    private VetRepository vetRepository;

    /**
     * @param visitPOJO visit's pojo
     * @return a string message
     */
    public String saveVisit(VisitPOJO visitPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        visitRepository = new VisitRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        vetRepository = new VetRepositoryImpl(entityManager);
        // Creating an optional pet object and find the id of the pet in the visit's pojo
        Optional<Pet> pet = petRepository.findById(visitPOJO.getPet_id());

        //if the id doesn't present return a string message
        if (!pet.isPresent()) return "El id de la mascota ingresado no existe!";
        // Creating an optional vet object and find the id of the vet in the visit's pojo
        Optional<Vet> vet = vetRepository.findById(visitPOJO.getVetUsername());
        //If the id doesn't exist return a string message
        if (!vet.isPresent()) return "El user name de la veterinaria ingresado no existe!";

        //Validating the format of the date, passing date of string to date
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date createdAt;
        try {
            createdAt = format.parse(visitPOJO.getCreated_at());
        } catch (ParseException e) {
            return "El formato de la fecha es incorrecto!";
        }

        //Creating the visit and save it in the repository
        Visit visit = new Visit(createdAt, visitPOJO.getType(), visitPOJO.getDescription(), vet.get(), pet.get());

        pet.ifPresent(p -> {
            p.addVisit(visit);
            petRepository.save(p);

        });

        vet.ifPresent(v -> {
            v.addVisit(visit);
            vetRepository.save(v);
        });

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
    public boolean verificateVisit(VisitPOJO visitPOJO) {
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

        if (pet.get().getMicrochip() != null) return false;
        return true;
    }
    /**
     * Finds the list of visits in a range of dates for a pet in a descending way
     *
     * @param date1   first date range
     * @param date2   second date range
     * @param petName the name of the pet to find
     * @return a list of visitPOJO
     */
    public List<VisitPOJO> findVisitsBetweenDatesByName(Date date1, Date date2, String petName) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        visitRepository = new VisitRepositoryImpl(entityManager);
        List<Visit> visits;
        if(date1.before(date2)){
            visits = visitRepository.findBetweenDatesByName(date1, date2);
        }else{
            visits = visitRepository.findBetweenDatesByName(date2, date1);
        }
        List<VisitPOJO> visitPOJOS = new ArrayList<>();

        visits.forEach(v -> {
            if (v.getPet().getName().equalsIgnoreCase(petName))
                visitPOJOS.add(new VisitPOJO(v.getVisitId(),
                        new SimpleDateFormat("dd/MM/yyyy").format(v.getCreatedAt()),
                        v.getType(),
                        v.getDescription(),
                        null,
                        v.getVet().getUsername(),
                        v.getPet().getPet_id()));
        });

        return visitPOJOS;
    }
    /**
     * Finds the list of visits in a range of dates for a pet in a descending way
     *
     * @param date1   first date range
     * @param date2   second date range
     * @param pet_id the pet id
     * @return a list of visitPOJO
     */
    public List<VisitPOJO> findVisitsBetweenDatesByPet(Date date1, Date date2, Integer pet_id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        visitRepository = new VisitRepositoryImpl(entityManager);
        List<Visit> visits;
        if(date1.before(date2)){
            visits = visitRepository.findBetweenDatesByName(date1, date2);
        }else{
            visits = visitRepository.findBetweenDatesByName(date2, date1);
        }
        List<VisitPOJO> visitPOJOS = new ArrayList<>();

        visits.forEach(v -> {
            if (v.getPet().getPet_id().equals(pet_id))
                visitPOJOS.add(new VisitPOJO(v.getVisitId(),
                        new SimpleDateFormat("dd/MM/yyyy").format(v.getCreatedAt()),
                        v.getType(),
                        v.getDescription(),
                        v.getPet().getMicrochip(),
                        v.getVet().getUsername(),
                        v.getPet().getPet_id()));
        });

        return visitPOJOS;
    }
}
