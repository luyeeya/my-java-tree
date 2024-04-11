package spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // 切面
@Component
public class LogAspect {

    @Before("execution(public * spring.aop.UserService.listUser())") // 切点
    public void test(JoinPoint joinPoint) {
        System.out.println("Before invoking listUser() ...");
    }

}
