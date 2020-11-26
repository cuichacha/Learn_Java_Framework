package dao;

import domain.Role;
import domain.Module;
import domain.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    public abstract List<Role> findAll();

    public abstract Role findById(String id);

    public abstract Integer save(Role role);

    public abstract Integer update(Role role);

    public abstract Integer delete(String id);

    public abstract Integer deleteRoleModule(String id);

    public abstract Integer saveRoleModule(@Param("roleId") String roleId, @Param("moduleId") String moduleId);

}
