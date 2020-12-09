import code.config.SpringConfig;
import code.domain.User;
import code.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {
    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        PageInfo<User> users = userService.findAll(1, 2);
        System.out.println(users);
    }
}
