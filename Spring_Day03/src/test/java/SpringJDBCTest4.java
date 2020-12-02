import code4.config.AppConfig;
import code4.domain.Account;
import code4.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SpringJDBCTest4 {
    @Autowired
    private AccountService accountService;

    @Test
    public void test1() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }
}
