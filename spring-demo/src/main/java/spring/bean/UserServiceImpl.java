package spring.bean;

import java.util.List;

public class UserServiceImpl {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> listUser() {
        return userMapper.listUser();
    }
}
