package com.shard.ing.controller;

import com.google.common.collect.Lists;
import com.shard.ing.config.ChSourceConfig;
import com.shard.ing.executor.CountTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
public class ChSourceController {

    @Resource
    private ChSourceConfig chSourceConfig ;

    @GetMapping("/countTable")
    public String countTable (){
        Set<String> keys = chSourceConfig.chSourceMap.keySet() ;
        if (keys.size() > 0){
            ExecutorService executor = Executors.newFixedThreadPool(keys.size());
            List<CountTask> countTasks = new ArrayList<>() ;
            for (String key:keys){
                Connection connection = chSourceConfig.connectionMap.get(key) ;
                String[] tables = chSourceConfig.chSourceMap.get(key) ;
                CountTask countTask = new CountTask(connection,tables) ;
                countTasks.add(countTask) ;
            }
            List<Future<Integer>> countList = Lists.newArrayList();
            try {
                if (countTasks.size() > 0){
                    countList = executor.invokeAll(countTasks) ;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer sumCount = 0 ;
            for (Future<Integer> count : countList){
                try {
                    Integer countRes = count.get();
                    sumCount = sumCount + countRes ;
                } catch (Exception e) {e.printStackTrace();}
            }
            return "sumCount="+sumCount ;
        }
        return "No Result" ;
    }

}
