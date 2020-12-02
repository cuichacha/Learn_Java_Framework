import code3.domain.Account;
import code3.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringJDBCTest3 {

    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringAOP3.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }
}
