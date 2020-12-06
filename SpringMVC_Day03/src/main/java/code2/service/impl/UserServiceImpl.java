package code2.service.impl;

import code2.dao.UserDao;
import code2.domain.User;
import code2.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public PageInfo<User> findAll(Integer startPage, Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        List<User> users = userDao.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public User login(String name, String password) {
        return userDao.getByUserNameAndPassword(name, password);
    }
}
