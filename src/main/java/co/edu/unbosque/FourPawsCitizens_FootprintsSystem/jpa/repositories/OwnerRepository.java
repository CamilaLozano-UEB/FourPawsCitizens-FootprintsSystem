package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;


import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Owner;

import java.util.List;

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
     * @param username the username of the owner
     * @param address,      the owner's address
     * @param neighborhood, the owner's neighborhood
     *
     * @return  a result message
     */
    String modify(String username, String address, String neighborhood);
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

}
