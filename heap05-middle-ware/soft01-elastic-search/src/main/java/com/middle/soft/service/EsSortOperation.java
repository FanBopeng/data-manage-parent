package com.middle.soft.service;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScriptSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EsSortOperation {

    @Resource
    private RestHighLevelClient client ;

    private final RequestOptions options = RequestOptions.DEFAULT;

    /**
     * 排序规则
     */
    public List<Map<String,Object>> sort (String indexName) {
        // 先升序时间，在倒序年龄
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.sort("createTime", SortOrder.ASC);
        sourceBuilder.sort("age",SortOrder.DESC) ;
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
     * 自定义排序规则
     */
    public List<Map<String,Object>> defSort (String indexName) {
        // 指定置换顺序的规则
        // [age 12-->60]\[age 19-->10]\[age 13-->30]\[age 18-->40],age其他值忽略为1
        Script script = new Script("def _ageSort = doc['age'].value == 12?60:" +
                                                            "(doc['age'].value == 19?10:" +
                                                            "(doc['age'].value == 13?30:" +
                                                            "(doc['age'].value == 18?40:1)));" + "_ageSort;");
        ScriptSortBuilder sortBuilder = SortBuilders.scriptSort(script,ScriptSortBuilder.ScriptSortType.NUMBER);
        sortBuilder.order(SortOrder.ASC);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.sort(sortBuilder);
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
