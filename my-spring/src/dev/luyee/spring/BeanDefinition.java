package dev.luyee.spring;

/**
 * 为什么引入 BeanDefinition：
 * 多例 Bean 和 lazy-init 的 Bean 在使用时才实例化 Bean，考虑到效率问题，
 * 启动容器时将扫描的 class 文件信息保存到 BeanDefinition，避免 getBean() 时再次扫描
 */
public class BeanDefinition {
    //    String SCOPE_SINGLETON = "singleton";
//    String SCOPE_PROTOTYPE = "prototype";
    private Class<?> beanClass;
    private String scope;
    private Boolean lazyInit;

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return this.beanClass;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isSingleton() {
        return "singleton".equals(this.scope) || "".equals(this.scope);
    }

    public boolean isPrototype() {
        return "prototype".equals(this.scope);
    }

    public Boolean getLazyInit() {
        return this.lazyInit;
    }

    public void setLazyInit(Boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public boolean isLazyInit() {
        return this.lazyInit != null && this.lazyInit;
    }
}
