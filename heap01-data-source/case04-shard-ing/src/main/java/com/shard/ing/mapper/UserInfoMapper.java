package com.shard.ing.mapper;

import com.shard.ing.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface UserInfoMapper {

    void batchInsert(@Param("userList") List<UserInfoEntity> userList);

    UserInfoEntity selectByPhone (@Param("userPhone") String userPhone);
}
