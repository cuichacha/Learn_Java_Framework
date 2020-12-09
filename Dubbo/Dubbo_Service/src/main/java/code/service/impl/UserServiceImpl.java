package code.service.impl;

import code.domain.User;
import code.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

@DubboService(timeout = 3000, retries = 3)
public class UserServiceImpl implements UserService {
    @Override
    public String hello() {
        return "Hello";
    }

    public User findById(Integer id) {
        User user = new User(1,"啦啦啦","123");
        return user;
    }
}
