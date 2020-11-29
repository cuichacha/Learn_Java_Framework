import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class Test1 {

    @Test
    public void test1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("Spring.xml");
        UserService userService = (UserService) ioc.getBean("userService");
        userService.save();
    }
}
