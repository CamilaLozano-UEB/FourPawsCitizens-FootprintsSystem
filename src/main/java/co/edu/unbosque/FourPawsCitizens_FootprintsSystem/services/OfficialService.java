package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.NeighborhoodOwner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.TotalOwnersNeighborhood;

import javax.ejb.Stateless;
import java.util.*;

@Stateless
public class OfficialService {
    private OfficialRepository officialRepository;

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
}
