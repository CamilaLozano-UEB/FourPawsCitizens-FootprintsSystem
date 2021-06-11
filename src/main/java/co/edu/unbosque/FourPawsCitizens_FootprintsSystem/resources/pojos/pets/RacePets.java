package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets;

public class RacePets {
    private String race;
    private Integer total;

    public RacePets() {
    }

    /**
     *
     * @param race pet race type
     * @param total amount of type entered
     */
    public RacePets(String race, Integer total) {
        this.race = race;
        this.total = total;
    }

    /**
     *
     * @return pet race type
     */
    public String getRace() {
        return race;
    }

    /**
     *
     * @param race pet race type
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     *
     * @return amount of type entered
     */
    public Integer getTotal() {
        return total;
    }

    /**
     *
     * @param total amount of type entered
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
