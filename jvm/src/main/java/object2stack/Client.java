package object2stack;

/**
 * 对象栈上分配：逃逸分析 + 标量替换
 * 测试：
 * （1）基本没有GC：-Xmx16m -Xms16m -XX:+PrintGCDetails -XX:+DoEscapeAnalysis -XX:+EliminateAllocations
 * （2）发生大量GC：
 *      1. -Xmx16m -Xms16m -XX:+PrintGCDetails -XX:-DoEscapeAnalysis -XX:-EliminateAllocations
 *      2. -Xmx16m -Xms16m -XX:+PrintGCDetails -XX:-DoEscapeAnalysis -XX:+EliminateAllocations
 *      3. -Xmx16m -Xms16m -XX:+PrintGCDetails -XX:+DoEscapeAnalysis -XX:-EliminateAllocations
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 1_0000_0000; i++) {
            test();
        }
    }

    public static void test() {
        Order order = new Order();
        order.setId("1");
    }
}
