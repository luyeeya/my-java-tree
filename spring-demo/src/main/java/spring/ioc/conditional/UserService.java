package spring.ioc.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(MyCondition.class) // 符合 MyCondition 规定的条件才能成为 Bean
public class UserService {
    private User user;
}
