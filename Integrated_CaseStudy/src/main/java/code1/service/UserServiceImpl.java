package code1.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import code1.dao.UserDao;
import code1.domain.User;
import code1.domain.UserRole;
import utils.MD5Util;
import utils.MapperUtil;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public PageInfo<User> findByPage(Integer currentPage, Integer pageSize) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<User> users = mapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public User findById(String id) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, true);
        User user = mapper.findById(id);
        MapperUtil.close();
        return user;
    }

    @Override
    public Integer save(User user) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, true);
        user.setId(UUID.randomUUID().toString());
        user.setPassword(MD5Util.md5(user.getPassword()));
        Integer result = mapper.save(user);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(User user) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, true);
        Integer result = mapper.update(user);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(String id) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }

    @Override
    public List<UserRole> findRolesByUserId(String userId) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, true);
        List<UserRole> roles = mapper.findRolesByUserId(userId);
        MapperUtil.close();
        return roles;
    }

    @Override
    public void updateUserRole(String userId, String[] roleIds) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, false);
        try {
            mapper.deleteUserRole(userId);
            for (String roleId : roleIds) {
                if (roleId != null) {
                    mapper.saveUserRole(userId, roleId);
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

    @Override
    public User findByEmail(String email) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, true);
        User user = mapper.findByEmail(email);
        MapperUtil.commit();
        return user;
    }

    @Override
    public List<String> findModuleUrlsByUserId(String id) {
        UserDao mapper = MapperUtil.getMapper(UserDao.class, true);
        List<String> urls = mapper.findModulesUrlsByUserId(id);
        MapperUtil.commit();
        return urls;
    }
}
