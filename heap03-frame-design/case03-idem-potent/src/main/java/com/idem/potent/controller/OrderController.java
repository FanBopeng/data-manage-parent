package com.idem.potent.controller;

import com.idem.potent.entity.OrderState;
import com.idem.potent.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Api(value = "OrderController")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService ;

    @PostMapping("/submitOrder")
    public String submitOrder (OrderState orderState){
        OrderState orderState01 = orderService.queryOrder(orderState) ;
        if (orderState01 == null){
            // 正常业务流程
            orderService.createOrder(orderState) ;
            orderService.localBiz(orderState) ;
            orderService.paymentBiz(orderState) ;
        } else {
            switch (orderState01.getState()){
                case 1:
                    // 订单创建成功：后推执行本地和支付业务
                    orderService.localBiz(orderState01) ;
                    orderService.paymentBiz(orderState01) ;
                    break ;
                case 2:
                    // 订单本地业务成功：后推执行支付业务
                    orderService.paymentBiz(orderState01) ;
                    break ;
                default:
                    break ;
            }
        }
        return "success" ;
    }

    @PostMapping("/repeatSub")
    public String repeatSub (OrderState orderState){
        boolean flag = orderService.queryToken(orderState) ;
        if (flag){
            return "请勿重复提交订单" ;
        }
        return "success" ;
    }
}
