import code2.controller.UserController;
import code2.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SpringConfig.xml")
public class SpringTest {
    @Autowired
    private UserService userService;


    @Test
    public void test1() {
        System.out.println(userService.findById(2));
    }

}
