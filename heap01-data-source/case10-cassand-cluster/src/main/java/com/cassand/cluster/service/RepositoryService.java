package com.cassand.cluster.service;

import com.cassand.cluster.entity.UserInfo;
import com.cassand.cluster.repository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RepositoryService {

    @Resource
    private UserInfoRepository userInfoRepository ;

    // 保存
    public UserInfo save (UserInfo userInfo){
        return userInfoRepository.save(userInfo) ;
    }

    // 查询
    public UserInfo getById (Integer id){
        return userInfoRepository.findById(id).get() ;
    }

    // 修改
    public UserInfo update (UserInfo userInfo){
        // 主键ID存在的情况即为修改
        return userInfoRepository.save(userInfo);
    }

    // 删除
    public void deleteById (Integer id){
        userInfoRepository.deleteById(id);
    }
}
