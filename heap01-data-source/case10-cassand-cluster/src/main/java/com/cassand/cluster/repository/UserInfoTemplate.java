package com.cassand.cluster.repository;

import com.cassand.cluster.entity.UserInfo;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserInfoTemplate {

    @Resource
    private CassandraTemplate cassandraTemplate ;

    // 查询全部数据
    public List<UserInfo> getList (){
        return cassandraTemplate.select("SELECT * FROM user_info",UserInfo.class) ;
    }

    // 添加数据
    public UserInfo insert (UserInfo userInfo){
        return cassandraTemplate.insert(userInfo) ;
    }

    // 根据主键查询
    public UserInfo selectOneById (Integer id){
        return cassandraTemplate.selectOneById(id,UserInfo.class) ;
    }

    // 修改数据
    public UserInfo update (UserInfo userInfo){
        return cassandraTemplate.update(userInfo) ;
    }

    // 删除数据
    public Boolean deleteById (Integer id){
        return cassandraTemplate.deleteById(id,UserInfo.class) ;
    }
}
