package code.utils;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

@Component
public class ElasticSearchUtil {
    @Qualifier("getRestHighLevelClient")
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    //    @Autowired
//    public static void setRestHighLevelClient(RestHighLevelClient restHighLevelClient) {
//        ElasticSearchUtil.restHighLevelClient = restHighLevelClient;
//    }
    private SearchRequest getSearchRequest (String index) {
        SearchRequest searchRequest = new SearchRequest(index);
        return searchRequest;
    }


    private SearchSourceBuilder getSearchSourceBuilder() {
        return new SearchSourceBuilder();
    }

    private SearchSourceBuilder getSearchSourcedBuilder(QueryBuilder queryBuilder, Integer size) {
        SearchSourceBuilder searchSourceBuilder = getSearchSourceBuilder();
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.size(size);
        return searchSourceBuilder;
    }

    private SearchSourceBuilder getSearchSourcedBuilder(AggregationBuilder aggregationBuilder) {
        SearchSourceBuilder searchSourceBuilder = getSearchSourceBuilder();
        searchSourceBuilder.aggregation(aggregationBuilder);
        return searchSourceBuilder;
    }

    private void baseQuery(SearchRequest searchRequest, SearchSourceBuilder searchSourceBuilder) throws IOException {
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits searchHits = searchResponse.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    private Map<String, Aggregation> aggregationBaseQuery(SearchRequest searchRequest, SearchSourceBuilder searchSourceBuilder) throws IOException {
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        Aggregations aggregations = searchResponse.getAggregations();
        Map<String, Aggregation> stringAggregationMap = aggregations.asMap();
        return stringAggregationMap;
    }

    public void query(String index, QueryBuilder queryBuilder, Integer size) throws IOException {
        SearchRequest searchRequest = getSearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = getSearchSourcedBuilder(queryBuilder, size);
        baseQuery(searchRequest, searchSourceBuilder);
    }

    public Map<String, Aggregation> query(String index, AggregationBuilder aggregationBuilder) throws IOException {
        SearchRequest searchRequest = getSearchRequest(index);
        SearchSourceBuilder searchSourcedBuilder = getSearchSourcedBuilder(aggregationBuilder);
        Map<String, Aggregation> stringAggregationMap = aggregationBaseQuery(searchRequest, searchSourcedBuilder);
        return stringAggregationMap;
    }

    public Map<String, Aggregation> query(String index, QueryBuilder queryBuilder, AggregationBuilder aggregationBuilder) throws IOException {
        SearchRequest searchRequest = getSearchRequest(index);
        SearchSourceBuilder rawSearchSourceBuilder = getSearchSourceBuilder();
        rawSearchSourceBuilder.query(queryBuilder);
        SearchSourceBuilder searchSourceBuilder = rawSearchSourceBuilder.aggregation(aggregationBuilder);
        Map<String, Aggregation> stringAggregationMap = aggregationBaseQuery(searchRequest, searchSourceBuilder);
        return stringAggregationMap;
    }


}
