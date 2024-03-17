package proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TimeInvocationHandler implements InvocationHandler {
    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 创建动态代理对象
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 被代理对象的类加载器
                target.getClass().getInterfaces(), // 被代理对象的所有接口
                this); // 当前 TimeInvocationHandler 对象
    }

    /**
     * 代理逻辑
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.printf("%s方法耗时：%sms%n", method.getName(), end - start);
        return result;
    }
}
