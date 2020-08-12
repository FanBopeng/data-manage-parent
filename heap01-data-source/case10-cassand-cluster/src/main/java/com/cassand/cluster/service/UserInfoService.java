package com.cassand.cluster.service;

import com.cassand.cluster.entity.UserInfo;
import com.cassand.cluster.repository.UserInfoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoService {

    @Resource
    private UserInfoTemplate userInfoTemplate ;

    // 查询全部数据
    public List<UserInfo> getList (){
        return userInfoTemplate.getList() ;
    }

    // 添加数据
    public UserInfo insert (UserInfo userInfo){
        return userInfoTemplate.insert(userInfo) ;
    }

    // 根据主键查询
    public UserInfo selectOneById (Integer id){
        return userInfoTemplate.selectOneById(id) ;
    }

    // 修改数据
    public UserInfo update (UserInfo userInfo){
        return userInfoTemplate.update(userInfo) ;
    }

    // 删除数据
    public Boolean deleteById (Integer id){
        return userInfoTemplate.deleteById(id) ;
    }

}
