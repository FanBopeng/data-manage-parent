package com.global.uuid.mapper;

import com.global.uuid.entity.TempIdEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TempIdMapper {

    Integer insert (TempIdEntity tempIdEntity) ;

    Integer insertA (TempIdEntity tempIdEntity) ;

    Integer insertB (TempIdEntity tempIdEntity) ;

    Integer insertC (TempIdEntity tempIdEntity) ;
}
