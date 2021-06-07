package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OwnerRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.OwnerPOJO;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Owner owner = new Owner(ownerPOJO.getUsername(), ownerPOJO.getPerson_id(), ownerPOJO.getName(), ownerPOJO.getAddress(), ownerPOJO.getNeighborhood());
        String message = ownerRepository.save(owner);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

    public List<PetPOJO> listPets(String username) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerRepository = new OwnerRepositoryImpl(entityManager);

        Optional<Owner> owner = ownerRepository.findById(username);
        List<PetPOJO> petPOJOList = new ArrayList<>();
        owner.ifPresent(o ->
                o.getPets().forEach(petEntity ->
                        petPOJOList.add(new PetPOJO(
                                petEntity.getPet_id(),
                                petEntity.getMicrochip(),
                                petEntity.getName(),
                                petEntity.getSpecies(),
                                petEntity.getRace(),
                                petEntity.getSize(),
                                petEntity.getSex(),
                                petEntity.getPicture(),
                                o.getUsername()
                        ))));
        return petPOJOList;
    }

}