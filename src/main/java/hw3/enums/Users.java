package hw3.enums;

public enum Users {
    PETER("epam", "1234", "PITER CHAILOVSKII");

    private final String login;
    private final String password;
    private final String username;

    Users(String login, String password, String username) {
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