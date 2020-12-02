import code2.config.AppConfig;
import code2.domain.Account;
import code2.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class)
public class SpringTransactionTest2 {
//    @Autowired
//    private AccountService accountService;

//    @Test
//    public void test1() {
//        List<Account> accounts = accountService.findAll();
//        System.out.println(accounts);
//    }

    @Test
    public void test2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringTransaction2.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
//        System.out.println(accountService.findAll());
        accountService.transfer("Tom", "Sam", 100D);
    }

//    @Test
//    public void test3() {
//        accountService.transfer("Tom", "Sam", 100D);
//    }
}
