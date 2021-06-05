package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.jpa.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Annotations to configure the entity, give a name and define the named queries
 */
@Entity
@Table(name = "Visit")
@NamedQueries({
        @NamedQuery(name = "Visit.remove",
                query = "DELETE FROM Visit v WHERE v.id = :id")
})
/**
 * Visit entity
 */
public class Visit {

    /**
     * Define the attributes for the Visit entity, the Id and the relations
     */
    @Id
    @GeneratedValue
    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "vet_id")
    private Vet vet;

    @Column(name = "pet_id")
    private Pet pet;

    /**
     * @param visitId     the visit id
     * @param createdAt   the date of creation
     * @param type        the visit type
     * @param description the visit description
     * @param vet         the vet of the visit
     * @param pet         the pet of the visit
     */
    public Visit(Integer visitId, Date createdAt, String type, String description, Vet vet, Pet pet) {
        this.visitId = visitId;
        this.createdAt = createdAt;
        this.type = type;
        this.description = description;
        this.vet = vet;
        this.pet = pet;
    }

    public Visit() {
    }

    /**
     * @return the visit id
     */
    public Integer getVisitId() {
        return visitId;
    }

    /**
     * @param visitId the new visit id
     */
    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
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
     * @return the visit vet
     */
    public Vet getVet() {
        return vet;
    }

    /**
     * @param vet the new visit vet
     */
    public void setVet(Vet vet) {
        this.vet = vet;
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