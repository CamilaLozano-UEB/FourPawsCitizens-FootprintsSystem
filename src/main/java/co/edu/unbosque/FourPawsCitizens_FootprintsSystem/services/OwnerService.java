package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OwnerRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepositoryImpl;
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
        PetRepository petRepository = new PetRepositoryImpl(entityManager);
        //Create a owner optional object
        Optional<Owner> owner = ownerRepository.findById(username);

        List<Pet> pet =petRepository.findAll();
        List<PetPOJO> petPOJOList = new ArrayList<>();
        //If the owner exist, list the pets of this owner
        for (int i = 0; i < pet.size(); i++) {
            System.out.println("Espera");
            if(pet.get(i).getOwner().getUsername().equals(username)){
                System.out.println("Entra");
                petPOJOList.add(new PetPOJO(
                        pet.get(i).getPet_id(),
                        pet.get(i).getMicrochip(),
                        pet.get(i).getName(),
                        pet.get(i).getSpecies(),
                        pet.get(i).getRace(),
                        pet.get(i).getSize(),
                        pet.get(i).getSex(),
                        serverPath + pet.get(i).getPicture(),
                        username
                ));
            }
        }

        return petPOJOList;
    }

}