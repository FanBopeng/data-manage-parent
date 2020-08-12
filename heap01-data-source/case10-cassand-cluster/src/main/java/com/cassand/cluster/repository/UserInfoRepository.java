package com.cassand.cluster.repository;

import com.cassand.cluster.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Integer> {

}
