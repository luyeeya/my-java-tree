package proxy.static_;

public class UserServiceProxy implements UserService {
    private final UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    public void login(String username, String password) {
        long start = System.currentTimeMillis();
        target.login(username, password);
        long end = System.currentTimeMillis();
        System.out.printf("login方法耗时：%sms%n", end - start);
    }
}
