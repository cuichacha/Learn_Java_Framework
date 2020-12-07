package code2.service;

import code2.domain.User;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true, rollbackFor = Exception.class)
public interface UserService {
    @Transactional(readOnly = false)
    public abstract boolean save(User user);

    @Transactional(readOnly = false)
    public abstract boolean delete(Integer id);

    @Transactional(readOnly = false)
    public abstract boolean update(User user);

    public abstract User findById(Integer id);

    public abstract PageInfo<User> findAll(Integer startPage, Integer pageSize);

    public abstract User login(String name, String password);
}
