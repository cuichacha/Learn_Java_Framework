import code.HelloApplication;
import code.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.boot.test.context.SpringBootTest(classes = HelloApplication.class)
public class SpringBootTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        System.out.println("啦啦啦");
    }

    @Test
    public void test2() {
        System.out.println(userService.findAll());
    }
}
