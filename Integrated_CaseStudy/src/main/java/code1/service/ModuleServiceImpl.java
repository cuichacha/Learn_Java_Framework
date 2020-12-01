package code1.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import code1.dao.ModuleDao;
import code1.domain.Module;
import code1.domain.RoleModule;
import utils.MapperUtil;

import java.util.List;
import java.util.UUID;

public class ModuleServiceImpl implements ModuleService {
    @Override
    public PageInfo<Module> findByPage(Integer currentPage, Integer pageSize) {
        ModuleDao mapper = MapperUtil.getMapper(ModuleDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<Module> departments = mapper.findAll();
        PageInfo<Module> pageInfo = new PageInfo<>(departments);
        MapperUtil.close();
        return pageInfo;
    }

    @Override
    public List<Module> findAll() {
        ModuleDao mapper = MapperUtil.getMapper(ModuleDao.class, true);
        List<Module> departments = mapper.findAll();
        MapperUtil.close();
        return departments;
    }

    @Override
    public Module findById(String id) {
        ModuleDao mapper = MapperUtil.getMapper(ModuleDao.class, true);
        Module module = mapper.findById(id);
        MapperUtil.close();
        return module;
    }

    @Override
    public Integer save(Module module) {
        ModuleDao mapper = MapperUtil.getMapper(ModuleDao.class, true);
        module.setId(UUID.randomUUID().toString());
        Integer result = mapper.save(module);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(Module module) {
        ModuleDao mapper = MapperUtil.getMapper(ModuleDao.class, true);
        Integer result = mapper.update(module);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(String id) {
        ModuleDao mapper = MapperUtil.getMapper(ModuleDao.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }

    @Override
    public List<RoleModule> findModuleByRoleId(String roleId) {
        ModuleDao mapper = MapperUtil.getMapper(ModuleDao.class, true);
        List<RoleModule> roleModules = mapper.findAuthorizationDataByRoleId(roleId);
        MapperUtil.close();
        return roleModules;
    }

    @Override
    public List<Module> findModuleByUserId(String id) {
        ModuleDao mapper = MapperUtil.getMapper(ModuleDao.class, true);
        List<Module> modules = mapper.findModuleByUserId(id);
        MapperUtil.close();
        return modules;
    }
}
