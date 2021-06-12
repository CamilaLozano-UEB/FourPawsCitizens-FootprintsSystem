package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.cases;

import java.util.ArrayList;
import java.util.List;

public class Cases {
    private Integer totalCases;
    private List<CaseByType> caseByType;

    /**
     * @param totalCases the total of cases
     * @param caseByType the list of cases
     */
    public Cases(Integer totalCases, List<CaseByType> caseByType) {
        this.totalCases = totalCases;
        this.caseByType = caseByType;
    }

    /**
     * @param totalCases the total of cases
     */
    public Cases(Integer totalCases) {
        this.totalCases = totalCases;
        this.caseByType = new ArrayList<>();
    }

    public Cases() {
    }

    /**
     * @return the total of cases
     */
    public Integer getTotalCases() {
        return totalCases;
    }

    /**
     * @param totalCases the new total of cases
     */
    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    /**
     * @return the total of cases
     */
    public List<CaseByType> getTotalCase() {
        return caseByType;
    }

    /**
     * @param caseByType the new list of total cases
     */
    public void setTotalCase(List<CaseByType> caseByType) {
        this.caseByType = caseByType;
    }
}
