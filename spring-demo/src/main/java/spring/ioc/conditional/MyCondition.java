package spring.ioc.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义 Condition
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 作用相当于：@ConditionalOnClass
        try {
            context.getClassLoader().loadClass("spring.ioc.conditional.User");
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }
}
