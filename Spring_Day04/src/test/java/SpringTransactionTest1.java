import code1.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringTransaction1.xml")
public class SpringTransactionTest1 {
    @Autowired
    private AccountService accountService;

    @Test
    public void test1() {
        accountService.transfer("Tom", "Sam", 100D);
    }
}
