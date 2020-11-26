package dao;

import domain.User;
import domain.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    public abstract List<User> findAll();

    public abstract User findById(String id);

    public abstract Integer save(User user);

    public abstract Integer update(User user);

    public abstract Integer delete(String id);

    public abstract List<UserRole> findRolesByUserId(String id);

    public abstract void deleteUserRole(String id);

    public abstract void saveUserRole(@Param("userId") String userId, @Param("roleId") String roleId);

    public abstract User findByEmail(String email);

    public abstract List<String> findModulesUrlsByUserId(String id);
}
