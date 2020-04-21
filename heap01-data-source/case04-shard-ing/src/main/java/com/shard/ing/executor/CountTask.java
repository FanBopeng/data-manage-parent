package com.shard.ing.executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.Callable;

public class CountTask implements Callable<Integer> {
    private Connection connection ;
    private String[] tableArray ;

    public CountTask(Connection connection, String[] tableArray) {
        this.connection = connection;
        this.tableArray = tableArray;
    }

    @Override
    public Integer call() throws Exception {
        Integer taskRes = 0 ;
        if (connection != null){
            Statement stmt = connection.createStatement();
            if (tableArray.length>0){
                for (String table:tableArray){
                    String sql = "SELECT COUNT(*) AS countRes FROM "+table ;
                    ResultSet resultSet = stmt.executeQuery(sql) ;
                    if (resultSet.next()){
                        Integer countRes = resultSet.getInt("countRes") ;
                        taskRes = taskRes + countRes ;
                    }
                }
            }
        }
        return taskRes ;
    }

}
