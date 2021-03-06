import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import code1.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringAOP1.xml")
public class SpringTest1 {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.findAll();
    }

    @Test
    public void test2() {
        String s = userService.findById("2");
    }

    @Test
    public void test3() {
        userService.save();
    }
}
