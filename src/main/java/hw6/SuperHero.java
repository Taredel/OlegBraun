package hw6;

public class SuperHero {

    private String number;
    private String user;
    private String description;

    public SuperHero(String number, String name, String description) {
        this.number = number;
        this.user = name;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "number='" + number + '\'' +
                ", user='" + user + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
