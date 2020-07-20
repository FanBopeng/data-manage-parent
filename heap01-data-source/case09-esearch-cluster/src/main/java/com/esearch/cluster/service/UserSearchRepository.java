package com.esearch.cluster.service;

import com.esearch.cluster.entity.UserSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserSearchRepository extends ElasticsearchRepository<UserSearch,Long> {

}
