package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Visit;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.NeighborhoodOwner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.TotalOwnersNeighborhood;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.*;

import javax.ejb.Stateless;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    public TotalOwnersNeighborhood getTotalOwners() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);

        List<String> neighborhoods = officialRepository.findAllNeighborhoods();
        Set<String> neighborhoodsSet = new HashSet<>(neighborhoods);

        TotalOwnersNeighborhood totalOwners = new TotalOwnersNeighborhood(neighborhoods.size());

        for (String neighborhood : neighborhoodsSet)
            totalOwners.addNeighborhoodOwnersTotal(
                    new NeighborhoodOwner(neighborhood, Collections.frequency(neighborhoods, neighborhood)));

        return totalOwners;
    }

    public Pets petsRegistered() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);
        petRepository = new PetRepositoryImpl(entityManager);

        // Find all the species
        List<String> elements = officialRepository.findAllSpecies();
        Set<String> elementsSet = new HashSet<>(elements);

        Pets petsPOJO = new Pets(elements.size());

        for (String species : elementsSet)
            petsPOJO.getSpeciesPets().add(new SpeciesPets(species, Collections.frequency(elements, species)));

        // find all the races
        elements = officialRepository.findAllRaces();
        elementsSet = new HashSet<>(elements);

        for (String race : elementsSet)
            petsPOJO.getRacePets().add(new RacePets(race, Collections.frequency(elements, race)));

        // find all the sizes
        elements = officialRepository.findAllSizes();
        elementsSet = new HashSet<>(elements);

        for (String size : elementsSet)
            petsPOJO.getSizePets().add(new SizePets(size, Collections.frequency(elements, size)));

        // find all the sexes
        elements = officialRepository.findAllSexes();
        elementsSet = new HashSet<>(elements);

        for (String sex : elementsSet)
            petsPOJO.getSexPets().add(new SexPets(sex, Collections.frequency(elements, sex)));

        petsPOJO.setTotalPetsWithMicrochip(officialRepository.countPetsWithMicrochip());
        System.out.println("verga" + officialRepository.countPetsWithMicrochip());
        List<Pet> pets = petRepository.findAll();

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

}
