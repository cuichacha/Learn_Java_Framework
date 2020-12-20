package code.enhancedes;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnhancedESQueryTest {

    public QueryBuilder test8() {
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price");
        rangeQueryBuilder.gte(2000);
        rangeQueryBuilder.lte(3000);
        return rangeQueryBuilder;
    }

    public QueryBuilder test9() {
        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("title", "华*");
        return wildcardQueryBuilder;
    }
}
