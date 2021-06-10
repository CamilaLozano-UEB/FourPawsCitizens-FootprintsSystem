package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.UserApp;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.userApp.UserAppPOJO;

import java.util.List;
import java.util.Optional;

public interface UserAppRepository {

    /**
     * saves a new user to the db
     *
     * @param userApp the case to persist
     * @return a result message
     */
    String save(UserApp userApp);

    /**
     * Modify the attributes of an specific user
     *
     * @param userAppPojo the new data of the user in the db
     * @return a result message
     */
    String modify(UserAppPOJO userAppPojo);

    /**
     * Delete an user from the DB
     *
     * @param userApp the user to delete
     */
    void delete(UserApp userApp);

    /**
     * Find an user by id
     *
     * @param username user's id
     * @return an optional object of user
     */
    Optional<UserApp> findByUsername(String username);

    /**
     * Finds all the users of the db
     *
     * @return a list of users
     */
    List<UserApp> findAll();
}
