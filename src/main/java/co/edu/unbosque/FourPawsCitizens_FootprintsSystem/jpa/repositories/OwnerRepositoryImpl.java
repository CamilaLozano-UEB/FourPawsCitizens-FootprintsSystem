package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.OwnerPOJO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class OwnerRepositoryImpl implements OwnerRepository {

    private EntityManager entityManager;

    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    /**
     * saves a new owner to the db
     *
     * @param owner the owner to be saved
     * @return a result message
     */
    @Override
    public String save(Owner owner) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(owner);
            entityManager.getTransaction().commit();
            return "se ha registrado correctamente";
        } catch (Exception e) {
            return "Ha ocurrido un error al registrar el propietario!";
        }
    }

    /**
     * Modify the attributes address and neighborhood of an specific owner
     *
     * @param ownerPOJO the pet with the new DB
     * @return a result message
     */
    @Override
    public String modify(OwnerPOJO ownerPOJO) {
        entityManager.getTransaction().begin();
        Optional<Owner> owner = this.findById(ownerPOJO.getUsername());
        if (!owner.isPresent()) return "No existe el propietario con el username ingresado";
        owner.get().setAddress(ownerPOJO.getAddress());
        owner.get().setNeighborhood(ownerPOJO.getNeighborhood());
        entityManager.getTransaction().commit();
        return "Se ha modificado exitosamente!";
    }

    /**
     * Finds all the owner of the db
     *
     * @return a list of owners
     */
    @Override
    public List<Owner> findAll() {
        return entityManager.createQuery("from Owner").getResultList();
    }

    /**
     * Finds all the owner by neighborhood of the db
     *
     * @return a list of owners of a specific neighborhood
     */
    @Override
    public List<Owner> findByNeighborhood(String neighborhood) {
        Query ownerQ = entityManager.createQuery("SELECT o FROM Owner o WHERE o.neighborhood = :neighborhood");
        ownerQ.setParameter("neighborhood", neighborhood);
        List<Owner> owners = ownerQ.getResultList();
        return owners;
    }

    /**
     * Finds an owner by id
     *
     * @param username owner's id
     * @return
     */
    @Override
    public Optional<Owner> findById(String username) {
        Owner owner = entityManager.find(Owner.class, username);
        return owner != null ? Optional.of(owner) : Optional.empty();
    }

}
