package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    public abstract List<User> findAll();

    public abstract User findById(String id);

    public abstract Integer save(User user);

    public abstract Integer update(User user);

    public abstract Integer delete(String id);
}
