package com.esearch.cluster.service;

import com.esearch.cluster.entity.UserSearch;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserSearchServiceImpl implements UserSearchService {

    @Resource
    private UserSearchRepository userSearchRepository ;

    @Override
    public String esInsert(Integer num) {
        for (int i = 0 ; i < num ; i++){
            UserSearch userSearch = new UserSearch() ;
            userSearch.setId(System.currentTimeMillis());
            userSearch.setUserId("Name"+i);
            userSearch.setUserName("ZSan"+i);
            userSearch.setSex("Male"+i);
            userSearchRepository.save(userSearch) ;
        }
        return "success" ;
    }

    @Override
    public Iterable<UserSearch> esFindAll (){
        return userSearchRepository.findAll() ;
    }

}
