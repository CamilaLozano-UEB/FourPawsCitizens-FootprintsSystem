package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets;

public class SexPets {
    private String sex;
    private Integer total;

    /**
     * @param sex   pet's sex type
     * @param total amount of type entered
     */
    public SexPets(String sex, Integer total) {
        this.sex = sex;
        this.total = total;
    }

    public SexPets() {
    }

    /**
     * @return pet's sex type
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex pet's sex type
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return amount of type entered
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total amount of type entered
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
