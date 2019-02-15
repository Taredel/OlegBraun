package hw3.enums;

public enum User {

    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String username;

    User(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}