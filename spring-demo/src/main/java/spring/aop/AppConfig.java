package spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("spring.aop")
@EnableAspectJAutoProxy // 开启 AOP
public class AppConfig {
}
