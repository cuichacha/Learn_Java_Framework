import code2.aoptest.AopTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringAOP2.xml")
public class SpringTest2 {
    @Autowired
    private AopTest aopTest;

    @Test
    public void test1() {
        aopTest.method();
    }
}
