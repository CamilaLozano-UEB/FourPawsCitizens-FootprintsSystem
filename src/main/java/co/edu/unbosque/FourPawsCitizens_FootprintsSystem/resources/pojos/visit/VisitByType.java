package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit;

public class VisitByType {
    private String type;
    private Integer total;

    /**
     * @param type  the type of the visit
     * @param total the total of visit of that type
     */
    public VisitByType(String type, Integer total) {
        this.type = type;
        this.total = total;
    }

    public VisitByType() {
    }

    /**
     * @return the type of the visit
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the new type of the visit
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the total of visits of the type
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the new total of visit of that type
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
