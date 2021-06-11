package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OfficialRepositoryImpl implements OfficialRepository {

    private EntityManager entityManager;

    public OfficialRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
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

    /**
     * @return finds all the neighborhoods of the table owner on the db
     */
    @Override
    public List<String> findAllNeighborhoods() {
        return entityManager.createQuery("select o.neighborhood from Owner o").getResultList();
    }

    /**
     * @return finds all the species of the table Pet on the db
     */
    @Override
    public List<String> findAllSpecies() {
        return entityManager.createQuery("select p.species from Pet p").getResultList();
    }

    /**
     * @return finds all the races of the table Pet on the db
     */
    @Override
    public List<String> findAllRaces() {
        return entityManager.createQuery("select p.race from Pet p").getResultList();
    }

    /**
     * @return finds all the sizes of the table Pet on the db
     */
    @Override
    public List<String> findAllSizes() {
        return entityManager.createQuery("select p.size from Pet p").getResultList();
    }

    /**
     * @return finds all the sexes of the table Pet on the db
     */
    @Override
    public List<String> findAllSexes() {
        return entityManager.createQuery("select p.sex from Pet p").getResultList();
    }

    /**
     * @return the number of pets with microchip
     */
    @Override
    public Long countPetsWithMicrochip() {
        return Collections.max((List<Long>) entityManager.createQuery("select count(p) from Pet p where p.microchip is not null").getResultList());
    }

    /**
     * @return finds all the types of cases of the table PetCase on the db
     */
    @Override
    public List<String> findAllCasesType() {
        return entityManager.createQuery("select c.type from PetCase c").getResultList();
    }

}
