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
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

public class VisitService {
    private VisitRepository visitRepository;
    private PetRepository petRepository;
    private VetRepository vetRepository;

    public String saveVisit(VisitPOJO visitPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        visitRepository = new VisitRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        vetRepository = new VetRepositoryImpl(entityManager);

        Optional<Pet> pet = petRepository.findById(visitPOJO.getPet_id());

        if (!pet.isPresent()) return "El id de la mascota ingresado no existe!";

        Optional<Vet> vet = vetRepository.findById(visitPOJO.getVetUsername());

        if (!vet.isPresent()) return "El user name de la veterinaria ingresado no existe!";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date createdAt;
        try {
            createdAt = format.parse(visitPOJO.getCreated_at());
        } catch (ParseException e) {
            return "El formato de la fecha es incorrecto!";
        }

        Visit visit = new Visit(createdAt, visitPOJO.getType(), visitPOJO.getDescription());

        pet.ifPresent(p -> {
            p.addVisit(visit);
        });

        vet.ifPresent(v -> {
            v.addVisit(visit);
        });

        visitRepository.save(visit);
        entityManager.close();
        entityManagerFactory.close();
        return "Se ha creado exitosamente la visita!";
    }
    public boolean verificateVisit(VisitPOJO visitPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);
        vetRepository = new VetRepositoryImpl(entityManager);

        Optional<Pet> pet = petRepository.findById(visitPOJO.getPet_id());

        if (!pet.isPresent()) return false;

        Optional<Vet> vet = vetRepository.findById(visitPOJO.getVetUsername());

        if (!vet.isPresent()) return false;

        if(pet.get().getMicrochip()!=null)  return false;
        return true;
    }
}
