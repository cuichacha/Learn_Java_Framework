package code.aop;

import code.enhancedes.EnhancedES;
import code.enhancedes.EnhancedESAggregationQuery;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.Max;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

@Component
@Aspect
public class EnhancingESAggregationQuery implements EnhancedES {
    @Qualifier("getRestHighLevelClient")
    @Autowired
    RestHighLevelClient restHighLevelClient;

    EnhancedES enhancedES = new EnhancedESAggregationQuery();

    @Pointcut("execution(* *.enhancedes.EnhancedESAggregationQuery.*(..))")
    public void pointCut() {

    }

    @Around(value = "pointCut()")
    public void query(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        SearchRequest searchQuest = new SearchRequest("goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        AggregationBuilder aggregationBuilder = (AggregationBuilder) proceedingJoinPoint.proceed();

//        AggregationBuilder aggregation = AggregationBuilders.max("max_price").field("price");
        searchSourceBuilder.aggregation(aggregationBuilder);
        searchQuest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchQuest, RequestOptions.DEFAULT);
        Aggregations aggregations = searchResponse.getAggregations();
//        Class<?> aClass = Class.forName("org.elasticsearch.search.aggregations.metrics.Max");
//        Object arg = args[0];
//        String typeName = arg.getClass().getTypeName();
//        Class<?> componentType = arg.getClass().getComponentType();

        Map<String, Aggregation> stringAggregationMap = aggregations.asMap();


    }
}
