import code2.config.AppConfig;
import code2.domain.Account;
import code2.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SpringJDBC {
    @Autowired
    private AccountService accountService;

    @Test
    public void test() {
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }
}
