package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit;

import java.util.ArrayList;
import java.util.List;

public class Visits {

    private Integer total;
    private List<VisitByType> visitByType;
    private List<VisitByVet> visitByVets;


    /**
     * @param visitByType a list of visit by type
     * @param visitByVets a list of the total visits by vet
     * @param total       the total of visits
     */
    public Visits(Integer total, List<VisitByType> visitByType, List<VisitByVet> visitByVets) {
        this.total = total;
        this.visitByType = visitByType;
        this.visitByVets = visitByVets;
    }

    public Visits(Integer total) {
        this.total = total;
        this.visitByType = new ArrayList<>();
        this.visitByVets = new ArrayList<>();
    }

    public Visits() {
    }

    /**
     * @return the list of the total visits by type
     */
    public List<VisitByType> getVisitByType() {
        return visitByType;
    }

    /**
     * @param visitByType a new list of VisitByType
     */
    public void setVisitByType(List<VisitByType> visitByType) {
        this.visitByType = visitByType;
    }

    /**
     * @return the list of the total visits by vets
     */
    public List<VisitByVet> getVisitByVets() {
        return visitByVets;
    }

    /**
     * @param visitByVets a new list of the total visits by vets
     */
    public void setVisitByVets(List<VisitByVet> visitByVets) {
        this.visitByVets = visitByVets;
    }

    /**
     * @return the total of visits
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total a new total of visits
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
