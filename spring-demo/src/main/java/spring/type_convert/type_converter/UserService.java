package spring.type_convert.type_converter;


import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    @Value("admin") // Spring 自动调用类型转换器进行类型转换
    private User admin;

    @Autowired
    private TypeConverter typeConverter;

    public User getAdminUser() {
        return admin;
    }

    public User getRandomUser() {
        Integer randUserId = new Random().nextInt(1000);
        // TypeConverter 自己会选择合适的类型转换器
        return this.typeConverter.convertIfNecessary(randUserId, User.class);
    }

}
