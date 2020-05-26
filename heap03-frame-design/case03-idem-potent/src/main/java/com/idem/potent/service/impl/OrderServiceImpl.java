package com.idem.potent.service.impl;

import com.idem.potent.entity.OrderState;
import com.idem.potent.entity.StateRecord;
import com.idem.potent.mapper.OrderStateMapper;
import com.idem.potent.mapper.StateRecordMapper;
import com.idem.potent.service.OrderService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderStateMapper orderStateMapper ;
    @Resource
    private StateRecordMapper stateRecordMapper ;

    @Override
    public OrderState queryOrder(OrderState orderState) {
        Map<String,Object> paramMap = new HashMap<>() ;
        paramMap.put("order_id",orderState.getOrderId());
        List<OrderState> orderStateList = orderStateMapper.selectByMap(paramMap);
        if (orderStateList != null && orderStateList.size()>0){
            return orderStateList.get(0) ;
        }
        return null ;
    }

    @Override
    public boolean createOrder(OrderState orderState) {
        int saveRes = orderStateMapper.insert(orderState);
        if (saveRes > 0){
            saveStateRecord(orderState.getOrderId(),"订单创建成功");
        }
        return saveRes > 0 ;
    }

    @Override
    public boolean localBiz(OrderState orderState) {
        orderState.setState(2);
        int updateRes = orderStateMapper.updateState(orderState) ;
        if (updateRes > 0){
            saveStateRecord(orderState.getOrderId(),"本地业务成功");
        }
        return updateRes > 0;
    }

    @Override
    public boolean paymentBiz(OrderState orderState) {
        orderState.setState(3);
        int updateRes = orderStateMapper.updateState(orderState) ;
        if (updateRes > 0){
            saveStateRecord(orderState.getOrderId(),"支付业务成功");
        }
        return updateRes > 0;
    }

    private void saveStateRecord (Long orderId,String stateDec){
        StateRecord stateRecord = new StateRecord() ;
        stateRecord.setOrderId(orderId);
        stateRecord.setStateDec(stateDec);
        stateRecordMapper.insert(stateRecord) ;
    }

    @Override
    public Boolean queryToken(OrderState orderState) {
        Map<String,Object> paramMap = new HashMap<>() ;
        paramMap.put("order_id",orderState.getOrderId());
        paramMap.put("token_id",orderState.getTokenId());
        List<OrderState> orderStateList = orderStateMapper.selectByMap(paramMap);
        return orderStateList.size() > 0 ;
    }
}
