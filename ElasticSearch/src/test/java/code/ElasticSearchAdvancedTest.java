package code;

import code.domain.Goods;
import code.mapper.GoodsMapper;
import code.service.GoodsService;
import code.utils.ElasticSearchUtil;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class ElasticSearchAdvancedTest {

    @Qualifier("getRestHighLevelClient")
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ElasticSearchUtil elasticSearchUtil;

    @Autowired
    GoodsService goodsService;

    @Test
    public void test1() throws IOException {
        BulkRequest bulkRequest= new BulkRequest();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "四号");
        map.put("age", "40");
        map.put("address", "北京昌平区");
        IndexRequest indexRequest1 = new IndexRequest("index_demo2").id("1").source(map);
        bulkRequest.add(indexRequest1);
        map.put("name", "五号");
        map.put("age", "50");
        map.put("address", "北京东城区");
        IndexRequest indexRequest2 = new IndexRequest("index_demo2").id("2").source(map);
        bulkRequest.add(indexRequest2);
        UpdateRequest updateRequest = new UpdateRequest("index_demo2", "1");
        map.put("name", "六号");
        updateRequest.doc(map);
        bulkRequest.add(updateRequest);
        DeleteRequest deleteRequest = new DeleteRequest("index_demo2").id("2");
        bulkRequest.add(deleteRequest);
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        BulkItemResponse[] items = bulkResponse.getItems();
        for (BulkItemResponse item : items) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void test2() throws IOException {
        List<Goods> goods = goodsService.findAll();
        for (Goods good : goods) {
            String specStr = good.getSpecStr();
            Map spec = JSON.parseObject(specStr, Map.class);
            good.setSpec(spec);
            BulkRequest bulkRequest = new BulkRequest();
            String s = JSON.toJSONString(good);
            IndexRequest indexRequest = new IndexRequest("goods").source(s, XContentType.JSON);
            bulkRequest.add(indexRequest);
            BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            BulkItemResponse[] items = bulkResponse.getItems();
//            for (BulkItemResponse item : items) {
//                System.out.println(item);
//            }
        }
    }

    @Test
    public void test3() throws IOException {
        SearchRequest searchRequest= new SearchRequest("goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        QueryBuilder queryBuilder = QueryBuilders.matchAllQuery();;
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(20);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        List<Goods> goodsList = new ArrayList<>();
        SearchHits searchHits = searchResponse.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            Goods goods = JSON.parseObject(sourceAsString, Goods.class);
            goodsList.add(goods);
        }
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    @Test
    public void test4() throws IOException {
        SearchRequest searchRequest = new SearchRequest("goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        QueryBuilder queryBuilder = QueryBuilders.termQuery("brandName", "华为");
        searchSourceBuilder.query(queryBuilder);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(1);
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits searchHits = searchResponse.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @Test
    public void test5() throws IOException {
        SearchRequest searchRequest = new SearchRequest("goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        QueryBuilder queryBuilder = QueryBuilders.termQuery("title", "华为");
        sourceBuilder.query(queryBuilder);
        sourceBuilder.from(0);
        sourceBuilder.size(1);
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits searchHits = searchResponse.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }

    @Test
    public void test6() throws IOException {
        WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery("title", "华*");
        elasticSearchUtil.getQueryBuilders("goods", wildcardQueryBuilder, 1);
//        ElasticSearchUtil.getQueryBuilders("goods", wildcardQueryBuilder, 1);
    }

    @Test
    public void test7() throws IOException {
        PrefixQueryBuilder prefixQueryBuilder = QueryBuilders.prefixQuery("title", "三");
        elasticSearchUtil.getQueryBuilders("goods", prefixQueryBuilder, 1);
    }


}
