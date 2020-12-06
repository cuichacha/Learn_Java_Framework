package code2.service;

import code2.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    public abstract boolean save(User user);

    public abstract boolean delete(Integer id);

    public abstract boolean update(User user);

    public abstract User findById(Integer id);

    public abstract PageInfo<User> findAll(Integer startPage, Integer pageSize);

    public abstract User login(String name, String password);
}
