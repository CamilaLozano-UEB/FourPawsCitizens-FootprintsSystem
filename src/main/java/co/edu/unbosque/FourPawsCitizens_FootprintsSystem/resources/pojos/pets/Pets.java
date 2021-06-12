package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets;

import java.util.ArrayList;
import java.util.List;

public class Pets {
    private Integer totalPets;
    private Long totalPetsWithMicrochip;
    private Integer totalPetsWithSterilization;
    private List<SexPets> sexPets;
    private List<SizePets> sizePets;
    private List<RacePets> racePets;
    private List<SpeciesPets> speciesPets;

    public Pets() {
    }

    /**
     * @param totalPets                  total pets
     * @param totalPetsWithMicrochip     total pets with microchip
     * @param totalPetsWithSterilization total pets with sterilization
     * @param sexPets                    Pet sex list
     * @param sizePets                   List of pet sizes
     * @param racePets                   List of pet races
     * @param speciesPets                List of pet species
     */
    public Pets(Integer totalPets, Long totalPetsWithMicrochip, Integer totalPetsWithSterilization, List<SexPets> sexPets, List<SizePets> sizePets, List<RacePets> racePets, List<SpeciesPets> speciesPets) {
        this.totalPets = totalPets;
        this.totalPetsWithMicrochip = totalPetsWithMicrochip;
        this.totalPetsWithSterilization = totalPetsWithSterilization;
        this.sexPets = sexPets;
        this.sizePets = sizePets;
        this.racePets = racePets;
        this.speciesPets = speciesPets;
    }

    /**
     * @param totalPets the total of pets
     */
    public Pets(Integer totalPets) {
        this.totalPets = totalPets;
        this.totalPetsWithMicrochip = 0L;
        this.totalPetsWithSterilization = 0;
        this.sexPets = new ArrayList<>();
        this.sizePets = new ArrayList<>();
        this.racePets = new ArrayList<>();
        this.speciesPets = new ArrayList<>();
    }

    /**
     * @return total pets
     */
    public Integer getTotalPets() {
        return totalPets;
    }

    /**
     * @param totalPets total pets
     */
    public void setTotalPets(Integer totalPets) {
        this.totalPets = totalPets;
    }

    /**
     * @return total pets with microchip
     */
    public Long getTotalPetsWithMicrochip() {
        return totalPetsWithMicrochip;
    }

    /**
     * @param totalPetsWithMicrochip total pets with microchip
     */
    public void setTotalPetsWithMicrochip(Long totalPetsWithMicrochip) {
        this.totalPetsWithMicrochip = totalPetsWithMicrochip;
    }

    /**
     * @return total pets with sterilization
     */
    public Integer getTotalPetsWithSterilization() {
        return totalPetsWithSterilization;
    }

    /**
     * @param totalPetsWithSterilization total pets with sterilization
     */
    public void setTotalPetsWithSterilization(Integer totalPetsWithSterilization) {
        this.totalPetsWithSterilization = totalPetsWithSterilization;
    }

    /**
     * @return Pet sex list
     */
    public List<SexPets> getSexPets() {
        return sexPets;
    }

    /**
     * @param sexPets Pet sex list
     */
    public void setSexPets(List<SexPets> sexPets) {
        this.sexPets = sexPets;
    }

    /**
     * @return List of pet sizes
     */
    public List<SizePets> getSizePets() {
        return sizePets;
    }

    /**
     * @param sizePets List of pet sizes
     */
    public void setSizePets(List<SizePets> sizePets) {
        this.sizePets = sizePets;
    }

    /**
     * @return List of pet races
     */
    public List<RacePets> getRacePets() {
        return racePets;
    }

    /**
     * @param racePets List of pet races
     */
    public void setRacePets(List<RacePets> racePets) {
        this.racePets = racePets;
    }

    /**
     * @return List of pet species
     */
    public List<SpeciesPets> getSpeciesPets() {
        return speciesPets;
    }

    /**
     * @param speciesPets List of pet species
     */
    public void setSpeciesPets(List<SpeciesPets> speciesPets) {
        this.speciesPets = speciesPets;
    }
}
