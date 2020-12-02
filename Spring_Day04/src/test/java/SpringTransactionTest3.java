import code3.config.AppConfig;
import code3.domain.Account;
import code3.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SpringTransactionTest3 {
    @Autowired
    private AccountService accountService;

    @Test
    public void test1() {
        System.out.println(accountService.findAll());
    }

    @Test
    public void test2() {
        accountService.transfer("Tom", "Sam", 100D);
    }

}
