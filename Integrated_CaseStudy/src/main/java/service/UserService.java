package service;

import com.github.pagehelper.PageInfo;
import domain.User;

import java.util.List;

public interface UserService {
    public abstract PageInfo<User> findByPage(Integer currentPage, Integer pageSize);

    public abstract User findById(String id);

    public abstract Integer save(User user);

    public abstract Integer update(User user);

    public abstract Integer delete(String id);
}
