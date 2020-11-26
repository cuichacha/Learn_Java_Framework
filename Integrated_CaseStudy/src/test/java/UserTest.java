import com.github.pagehelper.PageInfo;
import domain.Dept;
import domain.User;
import org.junit.Test;
import service.UserService;
import service.UserServiceImpl;

import java.util.Date;
import java.util.List;

public class UserTest {

    @Test
    public void test() {
        UserService userService = new UserServiceImpl();
//        PageInfo<User> pageInfo = userService.findByPage(1, 5);
//        System.out.println(pageInfo);

        List<String> urls = userService.findModuleUrlsByUserId("002108e2-9a10-4510-9683-8d8fd1d374ef");
        System.out.println(urls);
    }
}
