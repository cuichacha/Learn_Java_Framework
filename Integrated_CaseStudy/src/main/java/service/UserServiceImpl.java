package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserDao;
import domain.User;
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
}
