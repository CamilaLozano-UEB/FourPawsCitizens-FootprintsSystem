package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OwnerRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.OwnerPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OwnerService {

    private OwnerRepository ownerRepository;

    public String modifyOwner(OwnerPOJO ownerPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerRepository = new OwnerRepositoryImpl(entityManager);

        String message = ownerRepository.modify(ownerPOJO);
        entityManager.close();
        entityManagerFactory.close();
        return message;
    }
    public String saveOwner(OwnerPOJO ownerPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerRepository = new OwnerRepositoryImpl(entityManager);

        Owner owner = new Owner(ownerPOJO.getUsername(),ownerPOJO.getPerson_id(),ownerPOJO.getName(), ownerPOJO.getAddress(), ownerPOJO.getNeighborhood());
        String message = ownerRepository.save(owner);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

}