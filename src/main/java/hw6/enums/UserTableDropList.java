package hw6.enums;

public enum UserTableDropList {
    ADMIN("Admin"),
    USER("User"),
    MANAGER("Manager");

    public String value;

    UserTableDropList(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
