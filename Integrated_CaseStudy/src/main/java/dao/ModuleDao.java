package dao;

import domain.Module;
import domain.RoleModule;

import java.util.List;

public interface ModuleDao {
    public abstract List<Module> findAll();

    public abstract Module findById(String id);

    public abstract Integer save(Module module);

    public abstract Integer update(Module module);

    public abstract Integer delete(String id);

    public abstract List<RoleModule> findAuthorizationDataByRoleId(String roleId);

    public abstract List<Module> findModuleByUserId(String id);
}
