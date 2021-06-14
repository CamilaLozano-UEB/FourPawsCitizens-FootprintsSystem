package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.PetCase;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Visit;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.*;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.VisitCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class PetService {

    private PetRepository petRepository;
    private OwnerRepository ownerRepository;
    private VisitRepository visitRepository;
    private CaseRepository caseRepository;

    /**
     * Method that saves a pet in a POJO
     *
     * @param petPOJO pet's pojo
     * @return string message
     */
    public String savePet(PetPOJO petPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);
        ownerRepository = new OwnerRepositoryImpl(entityManager);
        //Create an owner optional object an save the id that entry
        Optional<Owner> owner = ownerRepository.findById(petPOJO.getOwner_username());

        //If the owner with the id doesn't exists return a message
        if (!owner.isPresent()) return "El username del dueÃ±o ingresado no existe!";

        List<Pet> petList = petRepository.findAll();
        //If the owner with the id exist, scroll through the pet list to verify that the microchip does not exist
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getMicrochip() != null && petList.get(i).getMicrochip().equals(petPOJO.getMicrochip()))
                return "El microchip ingresado ya existe ";
        }
        //If the microchip doesn't exist save the pet in the pojo and save the pet in the owner
        Pet pet = new Pet(
                petPOJO.getMicrochip(),
                petPOJO.getName(),
                petPOJO.getSpecies(),
                petPOJO.getRace(),
                petPOJO.getSize(),
                petPOJO.getSex(),
                petPOJO.getPicture());
        owner.get().addPet(pet);

        ownerRepository.save(owner.get());

        entityManager.close();
        entityManagerFactory.close();
        return "Se ha registrado exitosamente la mascota!";
    }

    /**
     * Method that modify the data of a petPojo
     *
     * @param petPOJO pet's pojo
     * @return string message
     */
    public String modifyPet(PetPOJO petPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);

        List<Pet> petList = petRepository.findAll();
        //If the owner with the id exist, scroll through the pet list to verify that the microchip does not exist
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getMicrochip() != null && petList.get(i).getMicrochip().equals(petPOJO.getMicrochip())
                    && !petPOJO.getPet_id().equals(petList.get(i).getPet_id()) && petList.get(i).getMicrochip() != 0
                    && petPOJO.getMicrochip() != 0) {
                return "El microchip ingresado ya existe ";
            }

        }
        String message = petRepository.modify(petPOJO);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

    /**
     * List visits and cases in an specific range of date
     *
     * @param petId pet's id
     * @param init  first date
     * @param fin   last date
     * @return filtered list with cases an visits
     */
    public List<VisitCase> listVisitsAndCasesOnDateRange(Integer petId, Date init, Date fin) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);
        visitRepository = new VisitRepositoryImpl(entityManager);
        caseRepository = new CaseRepositoryImpl(entityManager);

        List<VisitCase> visitCaseList = new ArrayList<>();
        List<Visit> visits;
        //validate first date it's before last date in the visit
        if (init.before(fin)) {
            visits = visitRepository.findBetweenDatesByPetId(init, fin, petId);
        } else {
            visits = visitRepository.findBetweenDatesByPetId(fin, init, petId);
        }

        //Adding the visits to the list
        for (Visit visit : visits) {
            visitCaseList.add(new VisitCase(
                    visit.getCreatedAt(),
                    "Visita",
                    visit.getVisitId(),
                    visit.getPet().getName(),
                    visit.getType(),
                    visit.getDescription(),
                    visit.getVet().getName()));
        }
        List<PetCase> cases;

        //validate first date it's before last date in the cases
        if (init.before(fin)) {
            cases = caseRepository.findBetweenDates(init, fin, petId);
        } else {
            cases = caseRepository.findBetweenDates(fin, init, petId);
        }

        //Adding the cases to the list
        for (PetCase petCase : cases) {
            visitCaseList.add(new VisitCase(
                    petCase.getCreatedAt(),
                    "Caso",
                    petCase.getCaseId(),
                    petCase.getPet().getName(),
                    petCase.getType(),
                    petCase.getDescription(),
                    ""));
        }

        //organize the dates in Descending order
        Collections.sort(visitCaseList, new Comparator<VisitCase>() {
            public int compare(VisitCase o1, VisitCase o2) {
                if (o1.getCreatedAt() == null || o2.getCreatedAt() == null)
                    return 0;
                return o2.getCreatedAt().compareTo(o1.getCreatedAt());
            }
        });
        return visitCaseList;
    }

    /**
     * List the visits and cases without ranges
     *
     * @param petId
     * @return
     */
    public List<VisitCase> listVisitsAndCaseAll(Integer petId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);
        visitRepository = new VisitRepositoryImpl(entityManager);
        caseRepository = new CaseRepositoryImpl(entityManager);

        List<VisitCase> visitCaseList = new ArrayList<>();
        List<Visit> visits = visitRepository.findAll();

        //Save the visits in a visitCase List
        for (Visit visit : visits) {
            if (visit.getPet().getPet_id().equals(petId))
                visitCaseList.add(new VisitCase(
                        visit.getCreatedAt(),
                        "Visita",
                        visit.getVisitId(),
                        visit.getPet().getName(),
                        visit.getType(),
                        visit.getDescription(),
                        visit.getVet().getName()));

        }
        List<PetCase> cases = caseRepository.findAll();

        //Save the cases in a visitCase List
        for (PetCase petCase : cases) {
            if (petCase.getPet().getPet_id().equals(petId))
                visitCaseList.add(new VisitCase(
                        petCase.getCreatedAt(),
                        "Caso",
                        petCase.getCaseId(),
                        petCase.getPet().getName(),
                        petCase.getType(),
                        petCase.getDescription(),
                        ""));

        }

        //organize the dates in Descending order
        Collections.sort(visitCaseList, new Comparator<VisitCase>() {
            public int compare(VisitCase o1, VisitCase o2) {
                if (o1.getCreatedAt() == null || o2.getCreatedAt() == null)
                    return 0;
                return o2.getCreatedAt().compareTo(o1.getCreatedAt());
            }
        });
        return visitCaseList;
    }
}