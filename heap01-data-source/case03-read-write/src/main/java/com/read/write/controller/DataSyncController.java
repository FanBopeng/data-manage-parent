package com.read.write.controller;

import com.read.write.config.ConnectionFactory;
import com.read.write.config.ExecuteSqlUtil;
import com.read.write.config.JdbcConstant;
import com.read.write.entity.PageHelperEntity;
import com.read.write.entity.PageUtilEntity;
import com.read.write.entity.RwReadEntity;
import com.read.write.sqlfile.BuildSql;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DataSyncController {

    @Resource
    private ConnectionFactory connectionFactory ;

    @GetMapping("/readPage")
    public PageHelperEntity readPage (@RequestParam("page") Integer page){
        int pageSize = JdbcConstant.PAGE_SIZE ;
        int total = 0 ;
        try {
            Connection readConnection = connectionFactory.getByKey(JdbcConstant.READ) ;
            String countSql = BuildSql.buildCountSql("rw_read") ;
            ResultSet countSet = ExecuteSqlUtil.query(readConnection,countSql) ;
            while (countSet.next()){
                total = countSet.getInt("countNum") ;
            }
            String pageSql = BuildSql.buildPageSql("rw_read",
                             PageHelperEntity.countOffset(pageSize,page), pageSize) ;
            ResultSet pageSet = ExecuteSqlUtil.query(readConnection,pageSql) ;
            List<RwReadEntity> rwReadEntities = new ArrayList<>() ;
            while (pageSet.next()){
                RwReadEntity rwReadEntity = new RwReadEntity() ;
                rwReadEntity.setId(pageSet.getInt("id"));
                rwReadEntity.setSign(pageSet.getString("sign"));
                rwReadEntities.add(rwReadEntity) ;
            }
            return PageUtilEntity.pageResult(total,pageSize,page,rwReadEntities);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }

    @GetMapping("/dataSync")
    public List<RwReadEntity> dataSync (){
        List<RwReadEntity> rwReadEntities = new ArrayList<>() ;
        try {
            Connection readConnection = connectionFactory.getByKey(JdbcConstant.READ) ;
            String sql = BuildSql.buildSelectSql("rw_read") ;
            ResultSet resultSet = ExecuteSqlUtil.query(readConnection,sql) ;
            while (resultSet.next()){
                RwReadEntity rwReadEntity = new RwReadEntity() ;
                rwReadEntity.setId(resultSet.getInt("id"));
                rwReadEntity.setSign(resultSet.getString("sign"));
                rwReadEntities.add(rwReadEntity) ;
            }
            if (rwReadEntities.size() > 0){
                Connection writeConnection = connectionFactory.getByKey(JdbcConstant.WRITE) ;
                writeConnection.setAutoCommit(false);
                PreparedStatement statement = writeConnection.prepareStatement("INSERT INTO rw_read VALUES(?,?)");
                // 基于动态获取列，和statement.setObject();自动适配数据类型
                for (int i = 0 ; i < rwReadEntities.size() ; i++){
                    RwReadEntity rwReadEntity = rwReadEntities.get(i) ;
                    statement.setInt(1,rwReadEntity.getId()) ;
                    statement.setString(2,rwReadEntity.getSign()) ;
                    statement.addBatch();
                    if (i>0 && i%2==0){
                        statement.executeBatch() ;
                    }
                }
                // 处理最后一批数据
                statement.executeBatch();
                writeConnection.commit();
            }
            return rwReadEntities ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null ;
    }

}
