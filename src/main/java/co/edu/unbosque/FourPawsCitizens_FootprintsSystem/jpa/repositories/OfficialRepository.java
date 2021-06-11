package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.repositories;

import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Official;
import co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities.Vet;

import java.util.List;
import java.util.Optional;

public interface OfficialRepository {

    /**
     * Find an official by id
     *
     * @param username official's id
     * @return an optional object of official
     */
    Optional<Official> findById(String username);

    /**
     * Finds all the officials of the db
     *
     * @return a list of officials
     */
    List<Official> findAll();

    /**
     * @return finds all the neighborhoods of the table Owner on the db
     */
    List<String> findAllNeighborhoods();

    /**
     * @return finds all the species of the table Pet on the db
     */
    List<String> findAllSpecies();

    /**
     * @return finds all the races of the table Pet on the db
     */
    List<String> findAllRaces();

    /**
     * @return finds all the sizes of the table Pet on the db
     */
    List<String> findAllSizes();

    /**
     * @return finds all the sexes of the table Pet on the db
     */
    List<String> findAllSexes();

    /**
     * @return the number of pets with microchip
     */
    Long countPetsWithMicrochip();

    /**
     * @return finds all the types of cases of the table PetCase on the db
     */
    List<String> findAllCasesType();

    /**
     * @return all the vets that of the visits
     */
    List<Vet> findAllVisitsVets();

    /**
     * @return all the types of the visits
     */
    List<String> findAllVisitsType();


}
