package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.pets;

public class SizePets {
    private String size;
    private Integer total;

    public SizePets() {
    }

    /**
     * @param size  pet size type
     * @param total amount of type entered
     */
    public SizePets(String size, Integer total) {
        this.size = size;
        this.total = total;
    }

    /**
     * @return pet size type
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size pet size type
     */
    public void setSize(String size) {
        this.size = size;
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
