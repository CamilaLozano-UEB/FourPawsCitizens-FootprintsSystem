package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OwnerRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.OwnerRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.PetRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class PetService {

    private PetRepository petRepository;
    private OwnerRepository ownerRepository;

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
        if (!owner.isPresent()) return "El username del dueño ingresado no existe!";

        List<Pet> petList = petRepository.findAll();
        //If the owner with the id exist, scroll through the pet list to verify that the microchip does not exist
        for (int i = 0; i < petList.size(); ++i) {
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

        String message = petRepository.modify(petPOJO);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }
}