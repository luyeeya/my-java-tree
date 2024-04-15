package classloader.custom;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {
    private final String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 自定义搜索范围
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = name.replace('.', '/').concat(".class");
        String clazzPath = String.join("/", classPath, path);
        try (FileInputStream fis = new FileInputStream(clazzPath)) {
            byte[] data = new byte[fis.available()];
            fis.read(data);
            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    /**
     * 重写 loadClass() 打破双亲委派机制
     */
    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                if (name.startsWith("classloader.custom")) {
                    c = findClass(name);
                } else {
                    c = this.getParent().loadClass(name);
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("D:/data");
        Class<?> clazz = myClassLoader.loadClass("classloader.custom.GreetingService");
        System.out.println("The classLoader is: " + clazz.getClassLoader());
        Object instance = clazz.newInstance();
        Method greetMethod = clazz.getDeclaredMethod("greet", (Class<?>[]) null);
        greetMethod.invoke(instance, (Object[]) null);
    }
}
