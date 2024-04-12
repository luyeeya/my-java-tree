package spring.ioc.beandefinition;

import java.util.Arrays;
import java.util.List;

public class UserMapper {
    public List<User> listUser() {
        User user1 = new User("Tom");
        User user2 = new User("Jerry");
        User user3 = new User("ZhangSan");
        return Arrays.asList(user1, user2, user3);
    }
}
