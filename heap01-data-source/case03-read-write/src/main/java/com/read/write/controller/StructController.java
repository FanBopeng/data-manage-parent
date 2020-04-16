package com.read.write.controller;

import com.read.write.config.ConnectionFactory;
import com.read.write.config.ExecuteSqlUtil;
import com.read.write.config.JdbcConstant;
import com.read.write.entity.TableStructEntity;
import com.read.write.sqlfile.BuildSql;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StructController {

    private static Logger LOGGER = LoggerFactory.getLogger(StructController.class) ;

    @Resource
    private ConnectionFactory connectionFactory ;

    @GetMapping("/syncStruct")
    public String syncStruct (){
        try {
            String sql = BuildSql.buildStructSql("rw_read") ;
            ResultSet resultSet = ExecuteSqlUtil.query(connectionFactory.getByKey(JdbcConstant.READ),sql) ;
            String createTableSql = null ;
            while (resultSet.next()){
                createTableSql = resultSet.getString("Create Table") ;
            }
            if (StringUtils.isNotEmpty(createTableSql)){
                ExecuteSqlUtil.update(connectionFactory.getByKey(JdbcConstant.WRITE),createTableSql) ;
            }
            return "success" ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail" ;
    }

    @GetMapping("/tableStruct")
    public List<TableStructEntity> tableStruct (){
        List<TableStructEntity> tableStructEntities = new ArrayList<>() ;
        try {
            Connection connection = connectionFactory.getByKey(JdbcConstant.READ) ;
            String sql = BuildSql.buildTableSql(connection.getCatalog(),"rw_read") ;
            ResultSet resultSet = ExecuteSqlUtil.query(connection,sql) ;
            while (resultSet.next()){
                TableStructEntity tableStructEntity = new TableStructEntity() ;
                tableStructEntity.setColumnName(resultSet.getString("COLUMN_NAME"));
                tableStructEntity.setIsNullable(resultSet.getString("IS_NULLABLE"));
                tableStructEntity.setColumnType(resultSet.getString("COLUMN_TYPE"));
                tableStructEntity.setColumnKey(resultSet.getString("COLUMN_KEY"));
                tableStructEntity.setColumnComment(resultSet.getString("COLUMN_COMMENT"));
                tableStructEntities.add(tableStructEntity) ;
            }
            return tableStructEntities ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }

}
