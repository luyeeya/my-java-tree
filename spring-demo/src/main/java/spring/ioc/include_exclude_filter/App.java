package spring.ioc.include_exclude_filter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试 @ComponentScan 的 excludeFilter 排除过滤器 和 includeFilter 包含过滤器
 * <p>
 * 预期结果：
 * 1. 即使 UserService 上没有 @Service 注解，使用 includeFilter 后也能注册到容器
 * 2. 即使 OrderService 上有 @Service 注解，使用 excludeFilter 后也不能注册到容器
 * <p>
 * 过滤类型 FilterType 有 5 种：
 * 1. ANNOTATION：根据是否包含某个注解过滤
 * 2. ASSIGNABLE_TYPE：根据是否是某个类过滤
 * 3. ASPECTJ：根据是否符合某个 Aspectj 表达式过滤
 * 4. REGEX：根据是否符合某个正则表达式过滤
 * 5. CUSTOM：根据自定义过滤规则（规则通过 TypeFilter 定义）
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("userService", UserService.class));
        System.out.println(context.getBean("orderService", OrderService.class));
    }
}
