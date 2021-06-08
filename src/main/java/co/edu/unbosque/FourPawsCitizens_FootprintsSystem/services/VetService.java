package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.services;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Vet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.VetRepository;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories.VetRepositoryImpl;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.vet.VetPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VetService {

    private VetRepository vetRepository;

    /**
     * Method that modify the data of and petPojo object
     *
     * @param vetPOJO vet's Pojo
     * @return a string message
     */
    public String modifyVet(VetPOJO vetPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        vetRepository = new VetRepositoryImpl(entityManager);

        String message = vetRepository.modify(vetPOJO);
        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

    /**
     * Method that save a Vet in the db
     * @param vetPOJO vet's pojo
     * @return string message
     */
    public String saveVet(VetPOJO vetPOJO) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FootprintsSystemDS");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        vetRepository = new VetRepositoryImpl(entityManager);

        Vet vet = new Vet(vetPOJO.getUsername(), vetPOJO.getName(), vetPOJO.getAddress(), vetPOJO.getNeighborhood());
        String message = vetRepository.save(vet);

        entityManager.close();
        entityManagerFactory.close();
        return message;
    }

}
