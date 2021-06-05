package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class OfficialRepositoryImpl implements OfficialRepository {

    private EntityManager entityManager;

    public OfficialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * saves a new official to the db
     *
     * @param official the case to persist
     * @return a result message
     */
    @Override
    public String save(Official official) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(official);
            entityManager.getTransaction().commit();
            return "se ha registrado correctamente el oficial";
        } catch (Exception e) {
            return "Ha ocurrido un error al registrar el oficial!";
        }
    }

    /**
     * Modify the attributes of an specific official
     *
     * @param username the username of the official to be modified
     * @param name     the new name
     * @return a message of the result
     */
    @Override
    public String modify(String username, String name) {
        entityManager.getTransaction().begin();
        Optional<Official> official = this.findById(username);
        if (!official.isPresent()) return "No existe el oficial con el username ingresado!";
        official.get().setName(name);
        entityManager.getTransaction().commit();
        return "Se ha modificado exitosamente!";
    }

    /**
     * Delete an official from the DB
     *
     * @param official the official to delete
     */
    @Override
    public void delete(Official official) {
        entityManager.getTransaction().begin();
        entityManager.remove(official);
        entityManager.getTransaction().commit();
    }

    /**
     * Find an official by id
     *
     * @param username official's id
     * @return an optional object of official
     */
    @Override
    public Optional<Official> findById(String username) {
        Official official = entityManager.find(Official.class, username);
        return official != null ? Optional.of(official) : Optional.empty();
    }

    /**
     * Finds all the officials of the db
     *
     * @return a list of officials
     */
    @Override
    public List<Official> findAll() {
        return entityManager.createQuery("from Official ").getResultList();
    }
}
