package proxy.static_;

public class UserServiceImpl implements UserService {
    public void login(String username, String password) {
        System.out.printf("username: %s, password: %s%n", username, password);
        System.out.printf("%s logged in%n", username);
    }
}
