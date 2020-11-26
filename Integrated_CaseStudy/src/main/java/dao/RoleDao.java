package dao;

import domain.Role;
import domain.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    public abstract List<Role> findAll();

    public abstract Role findById(String id);

    public abstract Integer save(Role role);

    public abstract Integer update(Role role);

    public abstract Integer delete(String id);

    public abstract Integer deleteRoleModules(String id);

    public abstract Integer saveRoleModules(@Param("roleId") String roleId, @Param("moduleId") String moduleId);
}
