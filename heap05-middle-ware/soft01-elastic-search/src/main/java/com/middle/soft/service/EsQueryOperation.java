package com.middle.soft.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EsQueryOperation {

    @Resource
    private RestHighLevelClient client ;

    private final RequestOptions options = RequestOptions.DEFAULT;

    /**
     * 查询总数
     */
    public Long count (String indexName){
        // 指定创建时间
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.termQuery("createTime", 1611378102795L));

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(queryBuilder);

        CountRequest countRequest = new CountRequest(indexName);
        countRequest.source(sourceBuilder);
        try {
            CountResponse countResponse = client.count(countRequest, options);
            return countResponse.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 查询集合
     */
    public List<Map<String,Object>> list (String indexName) {
        // 查询条件,指定时间并过滤指定字段值
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.termQuery("createTime", 1611378102795L));
        queryBuilder.mustNot(QueryBuilders.termQuery("name","北京-李四"));
        sourceBuilder.query(queryBuilder);
        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse searchResp = client.search(searchRequest, options);
            List<Map<String,Object>> data = new ArrayList<>() ;
            SearchHit[] searchHitArr = searchResp.getHits().getHits();
            for (SearchHit searchHit:searchHitArr){
                Map<String,Object> temp = searchHit.getSourceAsMap();
                temp.put("id",searchHit.getId()) ;
                data.add(temp);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

    /**
     * 分页查询
     */
    public List<Map<String,Object>> page (String indexName,Integer offset,Integer size) {
        // 查询条件,指定时间并过滤指定字段值
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(offset);
        sourceBuilder.size(size);
        sourceBuilder.sort("createTime", SortOrder.DESC);
        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse searchResp = client.search(searchRequest, options);
            List<Map<String,Object>> data = new ArrayList<>() ;
            SearchHit[] searchHitArr = searchResp.getHits().getHits();
            for (SearchHit searchHit:searchHitArr){
                Map<String,Object> temp = searchHit.getSourceAsMap();
                temp.put("id",searchHit.getId()) ;
                data.add(temp);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }
}
