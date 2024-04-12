package spring.type_convert.conversion_service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    @Value("admin") // Spring 自动调用类型转换器进行类型转换
    private User admin;

    public User getAdminUser() {
        return admin;
    }

    public User getRandomUser() {
        String randUserId = String.valueOf(new Random().nextInt(1000));
        // 手动使用类型转换器进行类型转换
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(new String2UserConverter());
        return defaultConversionService.convert(randUserId, User.class);
    }

}
