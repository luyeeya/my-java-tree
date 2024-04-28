package gc;

import java.util.ArrayList;

/**
 * 不断触发 Minor GC，使用 jvisualvm 观察 GC 前后内存占用情况
 */
public class GC {
    private final byte[] content = new byte[1024 * 100]; // 100KB
    public static void main(String[] args) throws InterruptedException {
        ArrayList<GC> list = new ArrayList<>();
        long count = 0;
        while (true) {
            list.add(new GC());
            if (++count % 10 == 0) {
                System.out.printf("%sMB%n", count / 10);
            }
            Thread.sleep(10);
        }
    }
}
