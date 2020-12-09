package code.service;

import code.domain.User;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

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
