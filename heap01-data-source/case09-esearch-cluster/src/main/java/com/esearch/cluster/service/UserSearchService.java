package com.esearch.cluster.service;

import com.esearch.cluster.entity.UserSearch;

public interface UserSearchService {

    String esInsert(Integer num) ;

    Iterable<UserSearch> esFindAll () ;

}
