package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources.pojos.userApp;

public class UserAppPOJO {
    private String username;
    private String password;
    private String email;
    private String role;

    public UserAppPOJO() {
    }

    /**
     * @param username, the userApp's username
     * @param password, the userApp's password
     * @param email,    the userApp's email
     * @param role,     the userApp's role
     */
    public UserAppPOJO(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    /**
     * @return the userApp's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username, the new userApp's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the userApp's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password, the new userApp's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userApp's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email, the new userApp's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userApp's role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role, the userApp's role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
