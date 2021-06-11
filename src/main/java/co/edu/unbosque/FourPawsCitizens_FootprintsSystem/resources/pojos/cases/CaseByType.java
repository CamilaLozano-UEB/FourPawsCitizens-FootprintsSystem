package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.cases;

public class CaseByType {

    private String type;
    private Integer total;

    /**
     * @param type  the case type
     * @param total the total of cases
     */
    public CaseByType(String type, Integer total) {
        this.type = type;
        this.total = total;
    }

    public CaseByType() {
    }

    /**
     * @return the case type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the new case type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the total cases
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the new total cases
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
