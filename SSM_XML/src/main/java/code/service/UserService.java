package code.service;

import code.dao.UserDao;
import code.domain.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true, rollbackFor = Exception.class)
public interface UserService {

    @Transactional(readOnly = false)
    public abstract PageInfo<User> findAll(Integer startPage, Integer pageSize);

    @Transactional(readOnly = false)
    public abstract User findById(Integer id);

    public abstract boolean save(User user);

    public abstract boolean update(User user);

    public abstract boolean delete(Integer id);

    public abstract User login(String username, String password);

}
