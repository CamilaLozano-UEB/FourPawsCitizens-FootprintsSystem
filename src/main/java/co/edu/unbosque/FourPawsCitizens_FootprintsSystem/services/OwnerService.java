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

    /**
     * Method that modify the owner
     *
     * @param ownerPOJO owner's pojo
     * @return string message
     */
    public String modifyOwner(OwnerPOJO ownerPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerRepository = new OwnerRepositoryImpl(entityManager);
        //Save the data that arrive for ownerPojo
        String message = ownerRepository.modify(ownerPOJO);
        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

    /**
     * Method that save the owner in OwnerPOJO
     *
     * @param ownerPOJO owner's pojo
     * @return
     */
    public String saveOwner(OwnerPOJO ownerPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerRepository = new OwnerRepositoryImpl(entityManager);

        Owner owner = new Owner(
                ownerPOJO.getUsername(),
                ownerPOJO.getPassword(),
                ownerPOJO.getEmail(),
                ownerPOJO.getPerson_id(),
                ownerPOJO.getName(),
                ownerPOJO.getAddress(),
                ownerPOJO.getNeighborhood()
        );

        String message = ownerRepository.save(owner);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

    /**
     * Method that list all the pets of an owner, compare the username an list the pets with the same owner
     *
     * @param username owner's username
     * @return List of pet's Pojo
     */
    public List<PetPOJO> listPets(String username, String serverPath) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ownerRepository = new OwnerRepositoryImpl(entityManager);
        //Create a owner optional object
        Optional<Owner> owner = ownerRepository.findById(username);
        List<PetPOJO> petPOJOList = new ArrayList<>();
        //If the owner exist, list the pets of this owner
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
                                serverPath + petEntity.getPicture(),
                                o.getUsername()
                        ))));
        return petPOJOList;
    }

}