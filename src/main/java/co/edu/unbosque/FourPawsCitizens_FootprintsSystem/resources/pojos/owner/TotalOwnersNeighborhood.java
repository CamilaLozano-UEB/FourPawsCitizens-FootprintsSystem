package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.owner;

import java.util.ArrayList;
import java.util.List;

public class TotalOwnersNeighborhood {

    private Integer totalOwners;
    private List<NeighborhoodOwner> neighborhoodOwnersTotal;

    /**
     * @param neighborhoodOwnersTotal a list of neighborhoods with the total of owners
     * @param totalOwners             the total of owners
     */
    public TotalOwnersNeighborhood(List<NeighborhoodOwner> neighborhoodOwnersTotal, Integer totalOwners) {
        this.neighborhoodOwnersTotal = neighborhoodOwnersTotal;
        this.totalOwners = totalOwners;
    }

    /**
     * @param totalOwners the total of owners
     */
    public TotalOwnersNeighborhood(Integer totalOwners) {
        this.totalOwners = totalOwners;
        this.neighborhoodOwnersTotal = new ArrayList<>();
    }

    public TotalOwnersNeighborhood() {
    }

    /**
     * @param neighborhoodOwner add´s a new neighborhoodOwner
     */
    public void addNeighborhoodOwnersTotal(NeighborhoodOwner neighborhoodOwner) {
        this.neighborhoodOwnersTotal.add(neighborhoodOwner);
    }

    /**
     * @return the list of neighborhoods with the total of owners
     */
    public List<NeighborhoodOwner> getNeighborhoodOwnersTotal() {
        return neighborhoodOwnersTotal;
    }

    /**
     * @param neighborhoodOwnersTotal the new list of neighborhoods with the total of owners
     */
    public void setNeighborhoodOwnersTotal(List<NeighborhoodOwner> neighborhoodOwnersTotal) {
        this.neighborhoodOwnersTotal = neighborhoodOwnersTotal;
    }

    /**
     * @return the total of owners
     */
    public Integer getTotalOwners() {
        return totalOwners;
    }

    /**
     * @param totalOwners the new total of owners
     */
    public void setTotalOwners(Integer totalOwners) {
        this.totalOwners = totalOwners;
    }
}
