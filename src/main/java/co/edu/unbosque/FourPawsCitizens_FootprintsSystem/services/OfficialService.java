package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Vet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Visit;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OfficialRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OfficialRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.cases.CaseByType;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.cases.Cases;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.NeighborhoodOwner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.TotalOwnersNeighborhood;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.*;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit.VisitByType;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit.VisitByVet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit.Visits;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

@Stateless
public class OfficialService {
    private OfficialRepository officialRepository;
    private PetRepository petRepository;

    /**
     * List that calls the official
     *
     * @return a official's pojo
     */
    public List<OfficialPOJO> listOfficial() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);
        // List of official (entity)
        List<Official> officials = officialRepository.findAll();
        entityManager.close();
        entityManagerFactory.close();
        // Convert the customers list to an OfficialPOJO list
        List<OfficialPOJO> officialPOJOS = new ArrayList<>();
        for (Official official : officials) {
            officialPOJOS.add(new OfficialPOJO(
                    official.getUsername(),
                    official.getName()
            ));
        }
        return officialPOJOS;
    }

    /**
     * List the owners by their neighborhoods and save it in a object of totalOwnerNeighborhoods pojo
     *
     * @return object of total ownersNeighborhood
     */
    public TotalOwnersNeighborhood getTotalOwners() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);

        List<String> neighborhoods = officialRepository.findAllNeighborhoods();
        Set<String> neighborhoodsSet = new HashSet<>(neighborhoods);

        TotalOwnersNeighborhood totalOwners = new TotalOwnersNeighborhood(neighborhoods.size());

        //go through a hashset with the neighborhoods and save the owners starting from their neighborhood
        for (String neighborhood : neighborhoodsSet)
            totalOwners.addNeighborhoodOwnersTotal(
                    new NeighborhoodOwner(neighborhood, Collections.frequency(neighborhoods, neighborhood)));

        return totalOwners;
    }

    /**
     * List the pets registered for be filtered
     *
     * @return
     */
    public Pets petsRegistered() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);

        // Find all the species
        List<String> elements = officialRepository.findAllSpecies();
        Set<String> elementsSet = new HashSet<>(elements);

        Pets petsPOJO = new Pets(elements.size());
        //Filter by species
        for (String species : elementsSet)
            petsPOJO.getSpeciesPets().add(new SpeciesPets(species, Collections.frequency(elements, species)));

        // find all the races
        elements = officialRepository.findAllRaces();
        elementsSet = new HashSet<>(elements);
        //filter by race
        for (String race : elementsSet)
            petsPOJO.getRacePets().add(new RacePets(race, Collections.frequency(elements, race)));

        // find all the sizes
        elements = officialRepository.findAllSizes();
        elementsSet = new HashSet<>(elements);
        //filter by size
        for (String size : elementsSet)
            petsPOJO.getSizePets().add(new SizePets(size, Collections.frequency(elements, size)));

        // find all the sexes
        elements = officialRepository.findAllSexes();
        elementsSet = new HashSet<>(elements);
        //filter by sex
        for (String sex : elementsSet)
            petsPOJO.getSexPets().add(new SexPets(sex, Collections.frequency(elements, sex)));

        petsPOJO.setTotalPetsWithMicrochip(officialRepository.countPetsWithMicrochip());
        List<Pet> pets = petRepository.findAll();
        //counting by Sterilization
        int cont = 0;
        for (Pet pet : pets)
            for (Visit visit : pet.getVisits())
                if (visit.getType().equalsIgnoreCase("Esterilización")) {
                    cont++;
                    break;
                }

        petsPOJO.setTotalPetsWithSterilization(cont);
        return petsPOJO;
    }

    /**
     * Filter the cases  by type and save it in a list type pojo
     *
     * @return cases list of pojo type
     */
    public Cases findTotalCasesPerType() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);

        List<String> petCaseList = officialRepository.findAllCasesType();
        Set<String> petCaseListSet = new HashSet<>(petCaseList);

        Cases cases = new Cases(petCaseList.size());
        //Filter and save the cases by type
        for (String caseType : petCaseListSet)
            cases.getTotalCase().add(new CaseByType(caseType, Collections.frequency(petCaseList, caseType)));

        return cases;
    }

    /**
     * Filter and save in a list of type and vet
     *
     * @return visits list of pojo type
     */
    public Visits findTotalVisitsByVetAndType() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);

        List<Vet> vets = officialRepository.findAllVisitsVets();
        Set<Vet> vetsSet = new HashSet<>(vets);

        Visits visits = new Visits(vets.size());
        //Filter and save by the vet
        for (Vet vet : vetsSet)
            visits.getVisitByVets().add(new VisitByVet(vet.getName(), Collections.frequency(vets, vet)));

        List<String> types = officialRepository.findAllVisitsType();
        Set<String> typesSet = new HashSet<>(types);
        //Filter and save by the type of visit
        for (String type : typesSet)
            visits.getVisitByType().add(new VisitByType(type, Collections.frequency(types, type)));

        return visits;

    }

    /**
     * Filter and save the pets by the categories
     *
     * @param idF        id filter
     * @param microchipF microchip filter
     * @param nameF      name filter
     * @param speciesF   specie filter
     * @param raceF      race filter
     * @param sizeF      size filter
     * @param sexF       sex filter
     * @return filtered list where save it the pets
     */
    public List<PetBasicPOJO> findPetsFiltered(String idF, String microchipF, String nameF, String speciesF, String raceF, String sizeF, String sexF) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);

        //Query for the filter
        String query = (idF == null ? "" : " AND p.pet_id = " + idF) +
                (microchipF == null ? "" : " AND p.microchip = " + microchipF) +
                (nameF == null ? "" : " AND p.name = '" + nameF + "'") +
                (speciesF == null ? "" : " AND p.species IN (" + speciesF + ")") +
                (raceF == null ? "" : " AND p.race = '" + raceF + "'") +
                (sizeF == null ? "" : " AND p.size IN (" + sizeF + ")") +
                (sexF == null ? "" : " AND p.sex IN (" + sexF + ")");

        if (!query.isEmpty()) {
            query = " WHERE " + query.replaceFirst(" AND", "");
        }
        List<Pet> pets = officialRepository.findPetsWithFilter(query);
        List<PetBasicPOJO> petBasicPOJOList = new ArrayList<>();

        //Filter and save the pets by id, microchip, name, specie, race, size or sex
        for (Pet pet : pets) {
            petBasicPOJOList.add(new PetBasicPOJO(
                    pet.getPet_id(),
                    pet.getMicrochip(),
                    pet.getName(),
                    pet.getSpecies(),
                    pet.getRace(),
                    pet.getSize(),
                    pet.getSex(),
                    "http://35.206.97.221:8080/FourPawsCitizens-FootprintsSystem-1.0-SNAPSHOT/image/" + pet.getPicture())
            );
        }

        return petBasicPOJOList;
    }


}