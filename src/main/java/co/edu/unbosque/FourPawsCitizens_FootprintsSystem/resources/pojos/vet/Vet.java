package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.vet;

public class Vet {
    private String username;
    private String name;
    private String address;
    private String neighborhood;

    public Vet() {

    }

    /**
     * @param username,     the vet's username
     * @param name,         the vet's name
     * @param address,      the vet's address
     * @param neighborhood, the vet's neighborhood
     */
    public Vet(String username, String name, String address, String neighborhood) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.neighborhood = neighborhood;
    }

    /**
     * @return the vet's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username, the new vet's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the vet's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name, the new vet's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the vet's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address, the new vet's address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the vet's neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood, the new vet's neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
