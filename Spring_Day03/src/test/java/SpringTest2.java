import code2.domain.Account;
import code2.service.AccountService;
import code2.service.impl.XXServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringAOP2.xml")
public class SpringTest2 {
    @Autowired
    private XXServiceImpl xxService;

    @Test
    public void test1() {
        xxService.findAll();
    }
}
