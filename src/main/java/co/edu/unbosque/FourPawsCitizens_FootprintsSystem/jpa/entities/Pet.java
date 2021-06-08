package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Annotations to configure the entity, give a name and define the named queries
 */
@Entity
@Table(name = "Pet")
@NamedQueries({
        @NamedQuery(name = "Pet.findAll",
                query = "SELECT p FROM Pet p")

})
/**
 * Pet entity
 */
public class Pet {
    /**
     * Define the attributes for the Pet entity, the Id and the relations
     */
    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Integer pet_id;

    @Column(name = "microchip", unique = true)
    private Long microchip;

    @Column(name = "name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "race")
    private String race;

    @Column(name = "size")
    private String size;

    @Column(name = "sex")
    private String sex;

    @Column(name = "picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "username")
    private Owner owner;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Visit> visits = new HashSet<>();

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<PetCase> petCases = new HashSet<>();

    /**
     * @param microchip the microchip of the pet
     * @param name      the name of the pet
     * @param species   the species of the pet
     * @param race      the race of the pet
     * @param size      the size of the pet
     * @param sex       the sex of the pet
     * @param picture   the picture of the pet
     */
    public Pet(Long microchip, String name, String species, String race, String size, String sex, String picture) {
        this.microchip = microchip;
        this.name = name;
        this.species = species;
        this.race = race;
        this.size = size;
        this.sex = sex;
        this.picture = picture;
    }

    public Pet() {
    }

    public void addVisit(Visit visit) {
        this.visits.add(visit);
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
     * @return the owner of the pet
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @return the pet's visiting list
     */
    public Set<Visit> getVisits() {
        return visits;
    }

    /**
     * @param visits the pet's visiting list
     */
    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    /**
     * @param owner the owner of the pet
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * @return the pet's case list
     */
    public Set<PetCase> getCases() {
        return petCases;
    }

    /**
     * @param petCases the pet's visiting list
     */
    public void setCases(Set<PetCase> petCases) {
        this.petCases = petCases;
    }
}
