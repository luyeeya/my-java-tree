package spring.application_context.environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

/**
 * ApplicationContext 获取运行时环境（EnvironmentCapable）
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableEnvironment environment = context.getEnvironment();

        // SystemEnvironment：操作系统环境变量
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        System.out.println("systemEnvironment = " + systemEnvironment);

        // SystemProperties：Java系统属性（可以通过 JVM 启动参数或在程序中运行时设置）
        Map<String, Object> systemProperties = environment.getSystemProperties();
        System.out.println("systemProperties = " + systemProperties);

        // PropertySources：包括 systemEnvironment、systemProperties 和 @PropertySource 注解注入的属性
        MutablePropertySources propertySources = environment.getPropertySources();
        System.out.println("propertySources = " + propertySources);

        // 实际开发中直接使用：environment.getProperty()
        System.out.println("theme = " + environment.getProperty("theme"));
    }
}
