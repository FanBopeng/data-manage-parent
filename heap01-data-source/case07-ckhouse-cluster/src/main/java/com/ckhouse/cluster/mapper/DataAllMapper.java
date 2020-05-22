package com.ckhouse.cluster.mapper;

import com.ckhouse.cluster.entity.DataAllEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DataAllMapper {
    List<DataAllEntity> getList ();
}
