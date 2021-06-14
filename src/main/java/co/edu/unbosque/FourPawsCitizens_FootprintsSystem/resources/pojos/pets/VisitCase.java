package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets;


public class VisitCase {

    private String createdAt;
    private String caseOrVisit;
    private Integer idCaseVisit;
    private String petName;
    private String type;
    private String description;
    private String vetName;

    /**
     * @param createdAt   the date of creation
     * @param caseOrVisit if is case or visit
     * @param idCaseVisit the id of the case or visit
     * @param petName     the pet name
     * @param type        the type of visit or case
     * @param description the description of the visit or case
     * @param vetName     the vet name if is a visit
     */
    public VisitCase(String createdAt, String caseOrVisit, Integer idCaseVisit, String petName, String type, String description, String vetName) {
        this.createdAt = createdAt;
        this.caseOrVisit = caseOrVisit;
        this.idCaseVisit = idCaseVisit;
        this.petName = petName;
        this.type = type;
        this.description = description;
        this.vetName = vetName;
    }

    public VisitCase() {
    }

    /**
     * @return the date of creation
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the new date of creation
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return case if is a case or visit if not
     */
    public String getCaseOrVisit() {
        return caseOrVisit;
    }

    /**
     * @param caseOrVisit the new case or visit
     */
    public void setCaseOrVisit(String caseOrVisit) {
        this.caseOrVisit = caseOrVisit;
    }

    /**
     * @return the id of the case o visit
     */
    public Integer getIdCaseVisit() {
        return idCaseVisit;
    }

    /**
     * @param idCaseVisit the new id of the case or visit
     */
    public void setIdCaseVisit(Integer idCaseVisit) {
        this.idCaseVisit = idCaseVisit;
    }

    /**
     * @return the pet name
     */
    public String getPetName() {
        return petName;
    }

    /**
     * @param petName the new pet name
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * @return the type of the visit or case
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the new type of the visit or case
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the description of the visit or case
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the new description of the visit or case
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the vet name
     */
    public String getVetName() {
        return vetName;
    }

    /**
     * @param vetName the new vet name
     */
    public void setVetName(String vetName) {
        this.vetName = vetName;
    }
}