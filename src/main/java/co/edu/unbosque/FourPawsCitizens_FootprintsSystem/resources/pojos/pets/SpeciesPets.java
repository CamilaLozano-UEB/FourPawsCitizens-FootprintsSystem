package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets;

public class SpeciesPets {
    private String species;
    private Integer total;

    public SpeciesPets() {
    }

    /**
     * @param species type of pet species
     * @param total   amount of type entered
     */
    public SpeciesPets(String species, Integer total) {
        this.species = species;
        this.total = total;
    }

    /**
     * @return type of pet species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @param species type of pet species
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @return amount of type entered
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total amount of type entered
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
