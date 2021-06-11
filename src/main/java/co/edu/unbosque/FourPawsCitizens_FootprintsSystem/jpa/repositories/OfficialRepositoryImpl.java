package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.official.OfficialPOJO;

import javax.persistence.EntityManager;
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


}
