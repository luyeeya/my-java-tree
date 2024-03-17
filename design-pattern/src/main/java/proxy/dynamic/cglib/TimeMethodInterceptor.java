package proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法调用会被转发到该类的 intercept()方法
 */
public class TimeMethodInterceptor implements MethodInterceptor {
    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 创建动态代理对象
     */
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass()); // 将被代理对象的类设置成父类
        enhancer.setCallback(this); // 当前 TimeMethodInterceptor 对象
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, objects);
        long end = System.currentTimeMillis();
        System.out.printf("%s方法耗时：%sms%n", method.getName(), end - start);
        return result;
    }
}
