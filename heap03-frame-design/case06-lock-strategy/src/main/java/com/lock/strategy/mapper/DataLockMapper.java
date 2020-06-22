package com.lock.strategy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lock.strategy.entity.DataLockEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DataLockMapper extends BaseMapper<DataLockEntity> {

    DataLockEntity getById (@Param("id") Integer id) ;

    int updateByLock (@Param("id") Integer id,@Param("lockVersion") Integer lockVersion) ;

    int updateByInventory (@Param("id") Integer id,@Param("inventory") Integer inventory) ;
}
