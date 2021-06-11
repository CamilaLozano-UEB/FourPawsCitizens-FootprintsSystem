package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner;

public class NeighborhoodOwner {

    private String neighborhood;
    private Integer total;

    /**
     * @param neighborhood the neighborhood
     * @param total        the total neighborhood owners
     */
    public NeighborhoodOwner(String neighborhood, Integer total) {
        this.neighborhood = neighborhood;
        this.total = total;
    }

    public NeighborhoodOwner() {
    }

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the new neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the total of owners
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the new total of owners
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
