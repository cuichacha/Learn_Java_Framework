package service;

import com.github.pagehelper.PageInfo;
import domain.Role;

import java.util.List;

public interface RoleService {
    public abstract PageInfo<Role> findByPage(Integer currentPage, Integer pageSize);

    public abstract List<Role> findAll();

    public abstract Role findById(String id);

    public abstract Integer save(Role role);

    public abstract Integer update(Role role);

    public abstract Integer delete(String id);

    public abstract void updateRoleModules(String roleId, String[] moduleIds);
}
