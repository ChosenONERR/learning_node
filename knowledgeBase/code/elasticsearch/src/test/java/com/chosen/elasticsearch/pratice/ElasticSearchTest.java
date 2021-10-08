package com.chosen.elasticsearch.pratice;

import com.chosen.elasticsearch.entity.User;
import com.chosen.elasticsearch.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
public class ElasticSearchTest {

    @Autowired
    private RestHighLevelClient esClient;

    /**
     * 测试索引数据
     */
    @Test
    public void testIndex() throws IOException {
        log.info("client:::{}", esClient);
        IndexRequest request = new IndexRequest("users");
        request.id("1");
        User user = new User();
        user.setUsername("我是测试user");
        user.setAge(18);
        user.setAddress("我是测试user的地址");
        String jsonString = JsonUtils.toString(user);
        request.source(jsonString, XContentType.JSON);
        IndexResponse indexResponse = esClient.index(request, RequestOptions.DEFAULT);
        log.info("indexResponse:::{}", indexResponse);
    }

    /**
     * 测试复杂查询（DSL）
     */
    public void testDSLSearch(){

    }
}
