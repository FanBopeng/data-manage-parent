package com.post.gresql.service;

import com.post.gresql.entity.UserJsonEntity;

public interface UserJsonService {

    boolean addUserJson (UserJsonEntity userJsonEntity) ;

    UserJsonEntity findUserJson(Integer id);
}
