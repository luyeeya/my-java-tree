package object_size;

import org.openjdk.jol.info.ClassLayout;

/**
 * 查看对象占用内存大小
 */
public class Client {
    public static void main(String[] args) {
        ClassLayout userObjectLayout = ClassLayout.parseInstance(new User());
        System.out.println(userObjectLayout.toPrintable());
    }
}
