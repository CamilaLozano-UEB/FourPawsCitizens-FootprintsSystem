package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit;

public class VisitByVet {
    private String vetUsername;
    private Integer total;

    /**
     * @param vetUsername   the visit vet
     * @param total the visit total of that vet
     */
    public VisitByVet(String vetUsername, Integer total) {
        this.vetUsername = vetUsername;
        this.total = total;
    }

    public VisitByVet() {
    }

    /**
     * @return the username of the vet
     */
    public String getVetUsername() {
        return vetUsername;
    }

    /**
     * @param vetUsername the new username
     */
    public void setVetUsername(String vetUsername) {
        this.vetUsername = vetUsername;
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
