package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.UserApp;

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
     * @param username the username of the user
     * @param password user's password
     * @param email    user´s email
     * @param role     user's role
     * @return a result message
     */
    String modify(String username, String password, String email, String role);

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
    Optional<UserApp> findById(String username);

    /**
     * Finds all the users of the db
     *
     * @return a list of users
     */
    List<UserApp> findAll();
}
