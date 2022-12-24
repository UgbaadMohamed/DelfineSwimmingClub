public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }

        User other = (User) obj;
        return username.equalsIgnoreCase(other.username) &&
                password.equals(other.password);
    }

    // toString method
    @Override
    public String toString() {
        return username + password;
    }
}
//Ejerskab; Wei & isaac
