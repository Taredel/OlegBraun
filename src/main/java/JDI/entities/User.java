package JDI.entities;

import com.epam.jdi.tools.DataClass;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User extends DataClass<User> {

    public static User PETER = new User("epam", "1234", "PITER CHAILOVSKII");

    private String login;
    private String password;
    private String userName;
}
