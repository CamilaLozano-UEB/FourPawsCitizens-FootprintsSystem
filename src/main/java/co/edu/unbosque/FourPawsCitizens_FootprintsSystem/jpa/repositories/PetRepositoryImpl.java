package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Pet;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets.PetPOJO;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PetRepositoryImpl implements PetRepository {

    private EntityManager entityManager;

    public PetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * saves a new pet to the db
     *
     * @param pet the pet to be saved
     * @return a result message
     */
    @Override
    public String save(Pet pet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            return "se ha registrado correctamente";
        } catch (Exception e) {
            return "Ha ocurrido un error al registrar la mascota!";
        }
    }

    /**
     * Finds all the pets of the db
     *
     * @return a list of pets
     */
    @Override
    public List<Pet> findAll() {
        return entityManager.createQuery("from Pet").getResultList();
    }

    /**
     * Modify the attributes of an specific pet
     *
     * @param petPOJO the pet with the new data
     * @return a result message
     */
    @Override
    public String modify(PetPOJO petPOJO) {
        entityManager.getTransaction().begin();

        Optional<Pet> pet = this.findById(petPOJO.getPet_id());
        if (!pet.isPresent()) return "No existe la mascota con el id ingresado!";
        pet.get().setMicrochip(petPOJO.getMicrochip());
        pet.get().setName(petPOJO.getName());
        pet.get().setSpecies(petPOJO.getSpecies());
        pet.get().setRace(petPOJO.getRace());
        pet.get().setSize(petPOJO.getSize());
        pet.get().setSex(petPOJO.getSex());
        pet.get().setPicture(petPOJO.getPicture());

        entityManager.getTransaction().commit();

        return "Se ha modificado exitosamente!";
    }
    /**
     * Modify the attributes of an specific pet
     *
     * @param petPOJO the pet with the new data
     * @return a result message
     */
    @Override
    public String modifyForVisit(PetPOJO petPOJO) {
        entityManager.getTransaction().begin();

        Optional<Pet> pet = this.findById(petPOJO.getPet_id());
        if (!pet.isPresent()) return "No existe la mascota con el id ingresado!";

        pet.get().setMicrochip(petPOJO.getMicrochip());
        entityManager.getTransaction().commit();

        return "Se ha modificado exitosamente!";
    }

    /**
     * Finds a pet by id on the db
     *
     * @param petId the pet id to find
     * @return an Optional of pet
     */
    @Override
    public Optional<Pet> findById(Integer petId) {
        Pet pet = entityManager.find(Pet.class, petId);
        return pet != null ? Optional.of(pet) : Optional.empty();
    }
}
