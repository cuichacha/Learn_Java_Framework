package code1.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import code1.dao.RoleDao;
import code1.domain.Role;
import utils.MapperUtil;

import java.util.List;
import java.util.UUID;

public class RoleServiceImpl implements RoleService {
    @Override
    public PageInfo<Role> findByPage(Integer currentPage, Integer pageSize) {
        RoleDao mapper = MapperUtil.getMapper(RoleDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<Role> departments = mapper.findAll();
        PageInfo<Role> pageInfo = new PageInfo<>(departments);
        MapperUtil.close();
        return pageInfo;
    }

    @Override
    public List<Role> findAll() {
        RoleDao mapper = MapperUtil.getMapper(RoleDao.class, true);
        List<Role> departments = mapper.findAll();
        MapperUtil.close();
        return departments;
    }

    @Override
    public Role findById(String id) {
        RoleDao mapper = MapperUtil.getMapper(RoleDao.class, true);
        Role role = mapper.findById(id);
        MapperUtil.close();
        return role;
    }

    @Override
    public Integer save(Role role) {
        RoleDao mapper = MapperUtil.getMapper(RoleDao.class, true);
        role.setId(UUID.randomUUID().toString());
        Integer result = mapper.save(role);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(Role role) {
        RoleDao mapper = MapperUtil.getMapper(RoleDao.class, true);
        Integer result = mapper.update(role);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(String id) {
        RoleDao mapper = MapperUtil.getMapper(RoleDao.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }

    @Override
    public void updateRoleModule(String roleId, String[] moduleIds) {
        RoleDao mapper = MapperUtil.getMapper(RoleDao.class, false);
        try {
            mapper.deleteRoleModule(roleId);
            if (moduleIds != null) {
                for (String moduleId : moduleIds) {
                    Integer integer = mapper.saveRoleModule(roleId, moduleId);
                    System.out.println(integer);
                }
            }
            MapperUtil.commit();
        } catch (Exception e) {
            e.printStackTrace();
            MapperUtil.rollback();
        } finally {
            MapperUtil.close();
        }
    }

}
