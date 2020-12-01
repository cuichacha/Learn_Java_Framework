import code2.constructorTest.Person;
import code2.constructorTest.TheClass;
import code2.constructorTest.User;
import code2.constructorTest.UserFactory1;
import code2.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest2 {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring2.xml");

    @Test
    public void test1() {
        AccountService accountService = (AccountService) applicationContext.getBean("accountService1");
        accountService.testMethod();
    }

    @Test
    public void test2() {
        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService2");
        AccountService accountService2 = (AccountService) applicationContext.getBean("accountService2");
        AccountService accountService3 = (AccountService) applicationContext.getBean("accountService2");
        System.out.println(accountService1);
        System.out.println(accountService2);
        System.out.println(accountService3);
    }

    @Test
    public void test3() {
        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService3");
        AccountService accountService2 = (AccountService) applicationContext.getBean("accountService3");
        AccountService accountService3 = (AccountService) applicationContext.getBean("accountService3");
        System.out.println(accountService1);
        System.out.println(accountService2);
        System.out.println(accountService3);
    }

    @Test
    public void test4() {
        User user = (User) applicationContext.getBean("userFactory1");
        user.method();
    }

    @Test
    public void test5() {
        User user = (User) applicationContext.getBean("userFactory3");
        user.method();
    }

    @Test
    public void test6() {
        User user = (User) applicationContext.getBean("user");
        user.method();
        System.out.println(user.getId());
        System.out.println(user.getName());
        TheClass theClass = user.getTheClass();
        System.out.println(theClass.getName());
        theClass.method();
    }

    @Test
    public void test7() {
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.getId());
        System.out.println(person.getName());
        TheClass theClass = person.getTheClass();
        System.out.println(theClass.getName());
    }
}
