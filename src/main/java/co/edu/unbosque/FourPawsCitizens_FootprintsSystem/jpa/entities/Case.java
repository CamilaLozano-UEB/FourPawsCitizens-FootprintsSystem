package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Annotations to configure the entity, give a name and define the named queries
 */
@Entity
@Table(name = "Case")
@NamedQueries({
        @NamedQuery(name = "Case.remove",
                query = "DELETE FROM Case c WHERE c.id = :id")
})
/**
 * Case entity
 */
public class Case {

    /**
     * Define the attributes for the Visit entity, the Id and the relations
     */
    @Id
    @GeneratedValue
    @Column(name = "case_id")
    private Integer caseId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "pet_id")
    private Pet pet;

    /**
     * @param caseId      the case id
     * @param createdAt   the date of creation
     * @param type        the type of case
     * @param description the case description
     * @param pet         the pet of the case
     */
    public Case(Integer caseId, Date createdAt, String type, String description, Pet pet) {
        this.caseId = caseId;
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.pet = pet;
    }

    public Case() {
    }

    /**
     * @return the case id
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     * @param caseId the new case id
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     * @return the date of creation
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the new date of creation
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the visit type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the new visit type
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
     * @return the pet of the visit
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * @param pet the new visit pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
