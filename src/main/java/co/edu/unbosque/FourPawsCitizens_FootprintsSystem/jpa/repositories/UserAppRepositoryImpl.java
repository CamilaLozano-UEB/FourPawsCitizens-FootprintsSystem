package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.UserApp;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserAppRepositoryImpl implements UserAppRepository {

    private EntityManager entityManager;

    public UserAppRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * saves a new user to the db
     *
     * @param userApp the case to persist
     * @return a result message
     */
    @Override
    public String save(UserApp userApp) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userApp);
            entityManager.getTransaction().commit();
            return "se ha registrado correctamente el usuario";
        } catch (Exception e) {
            return "Ha ocurrido un error al registrar el usuario!";
        }
    }

    /**
     * Modify the attributes of an specific user
     *
     * @param username the username of the user
     * @param password user's password
     * @param email    user´s email
     * @param role     user's role
     * @return a result message
     */
    @Override
    public String modify(String username, String password, String email, String role) {
        entityManager.getTransaction().begin();
        Optional<UserApp> userApp = this.findById(username);
        if (!userApp.isPresent()) return "No existe el usuario con el username ingresado!";
        userApp.get().setPassword(password);
        userApp.get().setEmail(email);
        userApp.get().setRole(role);
        entityManager.getTransaction().commit();
        return "Se ha modificado exitosamente!";
    }

    /**
     * Delete an user from the DB
     *
     * @param userApp the user to delete
     */
    @Override
    public void delete(UserApp userApp) {
        entityManager.getTransaction().begin();
        entityManager.remove(userApp);
        entityManager.getTransaction().commit();
    }

    /**
     * Find an user by id
     *
     * @param username user's id
     * @return an optional object of user
     */
    @Override
    public Optional<UserApp> findById(String username) {
        UserApp userApp = entityManager.find(UserApp.class, username);
        return userApp != null ? Optional.of(userApp) : Optional.empty();
    }

    /**
     * Finds all the users of the db
     *
     * @return a list of users
     */
    @Override
    public List<UserApp> findAll() {
        return entityManager.createQuery("from UserApp ").getResultList();
    }
}
