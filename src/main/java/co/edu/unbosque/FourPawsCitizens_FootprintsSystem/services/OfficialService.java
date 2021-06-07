package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OfficialRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OfficialRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OfficialService {
    OfficialRepository officialRepository;

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




    private PetRepository petRepository;

    public String modifyPet(PetPOJO petPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        petRepository = new PetRepositoryImpl(entityManager);

        String message = petRepository.modify(petPOJO);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }
}
