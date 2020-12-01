package code1.service;

import com.github.pagehelper.PageInfo;
import code1.domain.User;
import code1.domain.UserRole;

import java.util.List;

public interface UserService {
    public abstract PageInfo<User> findByPage(Integer currentPage, Integer pageSize);

    public abstract User findById(String id);

    public abstract Integer save(User user);

    public abstract Integer update(User user);

    public abstract Integer delete(String id);

    public abstract List<UserRole> findRolesByUserId(String userId);

    public abstract void updateUserRole(String userId, String[] roleIds);

    public abstract User findByEmail(String email);

    public abstract List<String> findModuleUrlsByUserId(String id);
}
