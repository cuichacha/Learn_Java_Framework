package code.service;

import code.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public abstract List<User> findAll();
}
