package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.petCases;

public class CasePOJO {
    private Integer case_id;
    private String created_at;
    private String type;
    private String description;
    private Integer pet_id;

    /**
     * @param case_id     the case id
     * @param created_at  the creation date of the case
     * @param type        the type of case
     * @param description the description of case
     * @param pet_id      the pet id
     */
    public CasePOJO(Integer case_id, String created_at, String type, String description, Integer pet_id) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet_id = pet_id;
    }

    public CasePOJO() {
    }

    /**
     * @return the case id
     */
    public Integer getCase_id() {
        return case_id;
    }

    /**
     * @param case_id the case id
     */
    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    /**
     * @return the creation date of the case
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the creation date of the case
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the type of case
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type of case
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the description of case
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description of case
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pet id
     */
    public Integer getPet_id() {
        return pet_id;
    }

    /**
     * @param pet_id the pet id
     */
    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }
}
