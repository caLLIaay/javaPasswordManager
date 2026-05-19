package project;

public class Account {
    private String siteName;
    private String username;
    private String userPassword;

    Account(String siteName, String username, String userPassword) {
        this.siteName = siteName;
        this.username = username;
        this.userPassword = userPassword;
    }

    Account() {
        this.siteName = "Not specified";
        this.username = "Not specified";
        this.userPassword = "Not specified";
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public String toString() {
        return "Site name: " + getSiteName() + "\n" +
                "Account username: " +  getUsername() + "\n" +
                "Account password: " + getUserPassword() + "\n";
    }


}
