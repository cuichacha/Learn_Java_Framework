import collectiontrial.CollectionTrial;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class SpringTest {

    @Test
    public void test1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("Spring.xml");
        UserService userService = (UserService) ioc.getBean("userService1");
        userService.save();
    }

    @Test
    public void test2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("Spring.xml");
        UserService userService1 = (UserService) ioc.getBean("userService2");
        UserService userService2 = (UserService) ioc.getBean("userService2");
        UserService userService3 = (UserService) ioc.getBean("userService2");
        System.out.println(userService1);
        System.out.println(userService2);
        System.out.println(userService3);
    }

    @Test
    public void test3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
         UserService userService1 = (UserService) applicationContext.getBean("userService3");
         UserService userService2 = (UserService) applicationContext.getBean("userService3");
         UserService userService3 = (UserService) applicationContext.getBean("userService3");
        System.out.println(userService1);
        System.out.println(userService2);
        System.out.println(userService3);
    }

    @Test
    public void test4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userService1");
        userService.save();
    }

    @Test
    public void test5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }

    @Test
    public void test6() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        CollectionTrial collectionTest = (CollectionTrial) applicationContext.getBean("collectionTest");
        collectionTest.print();
    }

    @Test
    public void test7() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        UserService jdbcProp = (UserService) applicationContext.getBean("jdbcProp");
        jdbcProp.print();
    }
}
