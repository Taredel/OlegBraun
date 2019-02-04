package hw4.enums;

public enum SelenideUsers {
    PETER("epam", "1234", "PITER CHAILOVSKII");

    private final String login;
    private final String password;
    private final String username;

    SelenideUsers(String login, String password, String username) {
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
