package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.vet;

public class VetPOJO {
    private String username;
    private String password;
    private String email;
    private String role;
    private String name;
    private String address;
    private String neighborhood;

    public VetPOJO() {

    }

    /**
     * @param username,     the vet's username
     * @param password,     the vet´s password
     * @param email,        the vet´s email
     * @param role,         the vet´s role
     * @param name,         the vet's name
     * @param address,      the vet's address
     * @param neighborhood, the vet's neighborhood
     */
    public VetPOJO(String username, String password, String email, String role, String name, String address, String neighborhood) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
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
     * @return the vet password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the new vet password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the vet´s e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the new vet e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the vet role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the new vet role
     */
    public void setRole(String role) {
        this.role = role;
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
