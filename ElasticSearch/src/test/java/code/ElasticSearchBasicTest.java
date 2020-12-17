package code;

import code.domain.Person;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@SpringBootTest
public class ElasticSearchBasicTest {

    @Qualifier("getRestHighLevelClient")
    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void test1() {
        System.out.println(restHighLevelClient);
    }

    @Test
    public void test2() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index_demo1");
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.toString());
    }

    @Test
    public void test3() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("index_demo1");
        String mapping = "{\n" +
                "  \"properties\":{\n" +
                "    \"name\":{\n" +
                "      \"type\":\"keyword\"\n" +
                "    },\n" +
                "    \"age\":{\n" +
                "      \"type\":\"integer\"\n" +
                "    },\n" +
                "    \"address\":{\n" +
                "      \"type\":\"text\",\n" +
                "      \"analyzer\":\"ik_smart\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        createIndexRequest.mapping(mapping, XContentType.JSON);
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.toString());
    }

    @Test
    public void test4() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest("index_demo1");
        GetIndexResponse getIndexResponse = indices.get(getIndexRequest, RequestOptions.DEFAULT);
        Map<String, MappingMetaData> mappings = getIndexResponse.getMappings();
        mappings.forEach(new BiConsumer<String, MappingMetaData>() {
            @Override
            public void accept(String s, MappingMetaData mappingMetaData) {
                System.out.println(s + "---" + mappingMetaData.getSourceAsMap());
            }
        });
    }

    @Test
    public void test5() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest("index_demo1");
        System.out.println(indices.exists(getIndexRequest, RequestOptions.DEFAULT));
    }

    @Test
    public void test6() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("index_demo1");
        AcknowledgedResponse delete = indices.delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete);
    }

    @Test
    public void test7() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", "20");
        map.put("address", "北京海淀区");
        IndexRequest indexRequest = new IndexRequest("index_demo1").id("1").source(map);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getResult());
    }

    @Test
    public void test8() throws IOException {
        Person person = new Person("李四", "20", "北京朝阳区");
        String source = JSON.toJSONString(person);
        IndexRequest indexRequest = new IndexRequest("index_demo1").source(source, XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
    }

    @Test
    public void test9() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("index_demo1").id("1");
        DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.toString());
    }

}
