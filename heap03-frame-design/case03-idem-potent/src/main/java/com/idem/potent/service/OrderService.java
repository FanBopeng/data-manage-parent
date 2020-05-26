package com.idem.potent.service;

import com.idem.potent.entity.OrderState;

public interface OrderService {

    OrderState queryOrder (OrderState orderState) ;

    Boolean queryToken (OrderState orderState) ;

    boolean createOrder (OrderState orderState) ;

    boolean localBiz (OrderState orderState) ;

    boolean paymentBiz (OrderState orderState) ;
}
