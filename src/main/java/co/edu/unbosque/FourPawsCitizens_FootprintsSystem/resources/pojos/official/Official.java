package resources.pojos.official;

public class Official {

    private String Username;
    private String name;

    /**
     * @param username the username
     * @param name     the name of the official
     */
    public Official(String username, String name) {
        Username = username;
        this.name = name;
    }

    /**
     * @return the Official username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param username the new Official username
     */
    public void setUsername(String username) {
        Username = username;
    }

    /**
     * @return the Official name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the new Official name
     */
    public void setName(String name) {
        this.name = name;
    }
}