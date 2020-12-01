import org.junit.Test;
import code1.service.UserService;
import code1.service.UserServiceImpl;

import java.util.List;

public class UserTest {

    @Test
    public void test() {
        UserService userService = new UserServiceImpl();
//        PageInfo<User> pageInfo = userService.findByPage(1, 5);
//        System.out.println(pageInfo);

        List<String> urls = userService.findModuleUrlsByUserId("1");
        System.out.println(urls);
    }
}
