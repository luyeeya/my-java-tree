package proxy.dynamic.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

public class Main {
    public static void main(String[] args) {
        // CGLIB动态代理类输出到文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, Main.class.getResource("").getPath());

        Owl owl = new Owl();
        TimeMethodInterceptor timeMethodInterceptor = new TimeMethodInterceptor(owl);
        Owl ownProxy = (Owl) timeMethodInterceptor.getProxy();
        ownProxy.fly();
    }
}
