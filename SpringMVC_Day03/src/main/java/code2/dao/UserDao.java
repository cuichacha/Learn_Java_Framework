package code2.dao;

import code2.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public abstract boolean save(User user);

    public abstract boolean delete(Integer id);

    public abstract boolean update(User user);

    public abstract User findById(Integer id);

    public abstract List<User> findAll();

    public abstract User getByUserNameAndPassword(@Param("name") String name, @Param("password") String password);
}
