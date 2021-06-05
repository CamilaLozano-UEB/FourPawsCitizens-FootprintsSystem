package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    private Integer pet_id;
    private Long microchip;
    private String name;
    private String species;
    private String race;
    private String size;
    private String sex;
    private String picture;
    private String owner_username;

    public Pet() {
    }

    /**
     * @param pet_Id    the pet id
     * @param microchip the microchip of the pet
     * @param name      the name of the pet
     * @param species   the species of the pet
     * @param race      the race of the pet
     * @param size      the size of the pet
     * @param sex       the sex of the pet
     * @param picture   the picture of the pet
     * @param owner_id  the owner id of the pet
     */
    public Pet(Integer pet_Id, Long microchip, String name, String species, String race, String size, String sex, String picture, String owner_id) {
        this.pet_id = pet_Id;
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
        this.owner_username = owner_id;

    }

    /**
     * @return the pet id
     */
    public Integer getPet_id() {
        return pet_id;
    }

    /**
     * @return the name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name of the pet
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param pet_id the pet id
     */
    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }

    /**
     * @return the microchip of the pet
     */
    public Long getMicrochip() {
        return microchip;
    }

    /**
     * @param microchip the microchip of the pet
     */
    public void setMicrochip(Long microchip) {
        this.microchip = microchip;
    }

    /**
     * @return the species of the pet
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @param species the species of the pet
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @return the race of the pet
     */
    public String getRace() {
        return race;
    }

    /**
     * @param race the race of the pet
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * @return the size of the pet
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size of the pet
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the sex of the pet
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex of the pet
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the picture of the pet
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture of the pet
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the owner id of the pet
     */
    public String getOwner_username() {
        return owner_username;
    }

    /**
     * @param owner_username the owner id of the pet
     */
    public void setOwner_username(String owner_username) {
        this.owner_username = owner_username;
    }



}

