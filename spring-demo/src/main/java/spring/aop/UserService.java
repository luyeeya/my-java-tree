package spring.aop;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    public List<String> listUser() {
        return Arrays.asList("Tom", "Jerry", "ZhangSan");
    }

}
