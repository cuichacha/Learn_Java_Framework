import com.github.pagehelper.PageInfo;
import domain.Dept;
import domain.User;
import org.junit.Test;
import service.UserService;
import service.UserServiceImpl;

import java.util.Date;

public class UserTest {

    @Test
    public void test() {
        UserService userService = new UserServiceImpl();
        PageInfo<User> pageInfo = userService.findByPage(1, 5);
        System.out.println(pageInfo);
    }
}
