package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Vet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class VetRepositoryImpl implements VetRepository {

    private EntityManager entityManager;

    public VetRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * saves a new vet to the db
     *
     * @param vet the case to persist
     * @return a result message
     */
    @Override
    public String save(Vet vet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(vet);
            entityManager.getTransaction().commit();
            return "se ha registrado correctamente la veterinaria";
        } catch (Exception e) {
            return "Ha ocurrido un error al registrar la veterinaria!";
        }
    }

    /**
     * Modify the attributes of an specific vet
     *
     * @param username     the username of the vet
     * @param name         vet's password
     * @param address      vet´s email
     * @param neighborhood vet's role
     * @return a result message
     */
    @Override
    public String modify(String username, String name, String address, String neighborhood) {
        entityManager.getTransaction().begin();
        Optional<Vet> vet = this.findById(username);
        if (!vet.isPresent()) return "No existe la veterinaria con el username ingresado!";
        vet.get().setName(name);
        vet.get().setAddress(address);
        vet.get().setNeighborhood(neighborhood);
        entityManager.getTransaction().commit();
        return "Se ha modificado exitosamente!";
    }

    /**
     * Delete an vet from the DB
     *
     * @param vet the user to delete
     */
    @Override
    public void delete(Vet vet) {
        entityManager.getTransaction().begin();
        entityManager.remove(vet);
        entityManager.getTransaction().commit();
    }

    /**
     * Find a vet by id
     *
     * @param username vet's id
     * @return an optional object of vet
     */
    @Override
    public Optional<Vet> findById(String username) {
        Vet vet = entityManager.find(Vet.class, username);
        return vet != null ? Optional.of(vet) : Optional.empty();
    }

    /**
     * Finds all the vets of the db
     *
     * @return a list of vets
     */
    @Override
    public List<Vet> findAll() {
        return entityManager.createQuery("from Vet ").getResultList();
    }
}
