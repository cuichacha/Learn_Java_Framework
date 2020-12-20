package code.enhancedes;

import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.metrics.Max;
import org.springframework.stereotype.Component;

@Component
public class EnhancedESAggregationQuery implements EnhancedES {

    public AggregationBuilder test1() {
        AggregationBuilder aggregationBuilder = AggregationBuilders.max("max_price").field("price");

        return aggregationBuilder;
    }
}
