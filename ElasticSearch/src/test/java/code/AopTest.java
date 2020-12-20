package code;

import code.aoptest.AopTestTest;
import code.enhancedes.EnhancedElasticSearchTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {
    @Autowired
    private AopTestTest aopTestTest;

    @Autowired
    private EnhancedElasticSearchTest enhancedElasticSearchTest;

    @Test
    public void test1() {
        aopTestTest.testAop();
    }

    @Test
    public void test2() {
        enhancedElasticSearchTest.test8();
    }

}
