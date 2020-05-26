package com.idem.potent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.idem.potent.entity.OrderState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderStateMapper extends BaseMapper<OrderState> {

    int updateState(@Param("order") OrderState orderState);
}
