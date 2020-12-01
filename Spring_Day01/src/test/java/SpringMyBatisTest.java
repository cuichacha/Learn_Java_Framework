import code1.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import code1.service.AccountService;

import java.util.List;

public class SpringMyBatisTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringJDBC1.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringJDBC2.xml");
        code2.service.AccountService accountService = (code2.service.AccountService) applicationContext.getBean("accountService");
        List<code2.domain.Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }
}
