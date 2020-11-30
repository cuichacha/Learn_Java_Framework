import domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;
import service.impl.AccountServiceImpl;

import java.util.List;

public class SpringMyBatisTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringJDBC.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }
}
