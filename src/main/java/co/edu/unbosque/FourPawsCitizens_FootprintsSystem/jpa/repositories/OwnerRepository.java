package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner.OwnerPOJO;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    /**
     * saves a new owner to the db
     *
     * @param owner the owner to be saved
     * @return a result message
     */
    String save(Owner owner);

    /**
     * Modify the attributes address and neighborhood of an specific owner
     *
     * @param ownerPojo the pet with the new DB
     * @return a result message
     */
    String modify(OwnerPOJO ownerPojo);

    /**
     * Finds all the owner of the db
     *
     * @return a list of owners
     */
    List<Owner> findAll();

    /**
     * Finds all the owner by neighborhood of the db
     *
     * @return a list of owners of a specific neighborhood
     */
    List<Owner> findByNeighborhood(String neighborhood);

    /**
     * Finds an owner by id
     *
     * @param username owner's id
     * @return
     */
    Optional<Owner> findById(String username);
}
