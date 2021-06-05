package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.visit;

public class VisitPOJO {
    private Integer visit_id;
    private String created_at;
    private String type;
    private String description;
    private Long microchip;
    private Integer vet_id;
    private Integer pet_id;

    /**
     * @param visit_id    the visit id
     * @param created_at  the creation date of the visit
     * @param type        the type of visit
     * @param description the description of the visit
     * @param microchip   the pet microchip
     * @param vet_id      the veterinary id
     * @param pet_id      the pet id
     */
    public VisitPOJO(Integer visit_id, String created_at, String type, String description, Long microchip, Integer vet_id, Integer pet_id) {
        this.visit_id = visit_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.microchip = microchip;
        this.vet_id = vet_id;
        this.pet_id = pet_id;
    }

    public VisitPOJO() {

    }

    /**
     * @return the visit id
     */
    public Integer getVisit_id() {
        return visit_id;
    }

    /**
     * @return the new visit id
     */
    public void setVisit_id(Integer visit_id) {
        this.visit_id = visit_id;
    }

    /**
     * @return the creation date of the visit
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the new creation date of the visit
     */
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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
     * @return the visit description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the new visit description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the pet microchip of the visit
     */
    public Long getMicrochip() {
        return microchip;
    }

    /**
     * @return a new pet microchip of the visit
     */
    public void setMicrochip(Long microchip) {
        this.microchip = microchip;
    }

    /**
     * @return the vet id
     */
    public Integer getVet_id() {
        return vet_id;
    }

    /**
     * @param vet_id the new vet id
     */
    public void setVet_id(Integer vet_id) {
        this.vet_id = vet_id;
    }

    /**
     * @return the pet id
     */
    public Integer getPet_id() {
        return pet_id;
    }

    /**
     * @param pet_id the new pet id
     */
    public void setPet_id(Integer pet_id) {
        this.pet_id = pet_id;
    }
}
