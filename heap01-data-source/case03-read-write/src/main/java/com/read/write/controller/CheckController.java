package com.read.write.controller;

import com.read.write.config.ConnectionFactory;
import com.read.write.config.ExecuteSqlUtil;
import com.read.write.config.JdbcConstant;
import com.read.write.sqlfile.BuildSql;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.sql.SQLException;

@RestController
public class CheckController {

    @Resource
    private ConnectionFactory connectionFactory ;
    // MySQLSyntaxErrorException: SELECT command denied to user
    @GetMapping("/checkRead")
    public String checkRead (){
        try {
            String sql = BuildSql.buildReadSql("rw_read") ;
            ExecuteSqlUtil.query(connectionFactory.getByKey(JdbcConstant.READ),sql) ;
            return "success" ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail" ;
    }
    // MySQLSyntaxErrorException: INSERT command denied to user
    @GetMapping("/checkWrite")
    public String checkWrite (){
        try {
            String sql = BuildSql.buildWriteSql("rw_read") ;
            ExecuteSqlUtil.update(connectionFactory.getByKey(JdbcConstant.WRITE),sql) ;
            return "success" ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail" ;
    }
}
