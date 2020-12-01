import code1.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import code1.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AnnotationTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void test1() {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService.findAll());
    }
}
