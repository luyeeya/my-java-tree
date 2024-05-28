package performance_optimization;

import java.util.ArrayList;

/**
 * 堆OOM
 * [result expected] Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
public class HeapOOM {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        while (true) {
            users.add(new User());
        }
    }

    static class User {
        private final byte[] content = new byte[1024 * 100];
    }
}
