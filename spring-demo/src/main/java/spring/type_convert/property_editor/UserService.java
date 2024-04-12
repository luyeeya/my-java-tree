package spring.type_convert.property_editor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("admin") // Spring 自动调用类型转换器进行类型转换
    private User admin;

    public User getAdminUser() {
        return admin;
    }

}
