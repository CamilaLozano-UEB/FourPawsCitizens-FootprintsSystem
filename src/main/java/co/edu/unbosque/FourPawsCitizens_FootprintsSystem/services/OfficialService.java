package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OfficialRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OfficialRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OfficialService {
    OfficialRepository officialRepository;
    private PetRepository petRepository;


    public List<OfficialPOJO> listOfficial() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        officialRepository = new OfficialRepositoryImpl(entityManager);
        // List of customer (entity)
        List<Official> officials = officialRepository.findAll();
        entityManager.close();
        entityManagerFactory.close();
        // Convert the customers list to an CustomerPOJO list
        List<OfficialPOJO> officialPOJOS = new ArrayList<>();
        for (Official official : officials) {
            officialPOJOS.add(new OfficialPOJO(
                    official.getUsername(),
                    official.getName()
            ));
        }

        return officialPOJOS;
    }
}
