package runtime;

public class UserService {
    private static final User admin = new User("admin");

    public int doSomething() {
        int a = 2;
        int b = 3;
        return (a + b) * 10;
    }

    public static void main(String[] args) {
        UserService service = new UserService();
        int result = service.doSomething();
        System.out.println(result);
    }
}
