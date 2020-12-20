package code;

import code.aoptest.AopTestTest;
import code.enhancedes.EnhancedESAggregationQuery;
import code.enhancedes.EnhancedESQueryTest;
import org.elasticsearch.search.aggregations.metrics.InternalMax;
import org.elasticsearch.search.aggregations.metrics.Max;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {
    @Autowired
    private AopTestTest aopTestTest;

    @Autowired
    private EnhancedESQueryTest enhancedESQueryTest;

    @Autowired
    private EnhancedESAggregationQuery enhancedESAggregationQuery;

    @Test
    public void test1() {
        aopTestTest.testAop();
    }

    @Test
    public void test2() {
        enhancedESQueryTest.test8();
    }

    @Test
    public void test3() {
        enhancedESQueryTest.test9();
    }

    @Test
    public void test4() {
        enhancedESAggregationQuery.test1();
    }
}
