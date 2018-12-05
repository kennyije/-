package com.lyw.controller;

import com.lyw.constans.PayWay;
import com.lyw.factory.impl.PayWayFactory;
import com.lyw.service.PayService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
/**
 * Created by Lenovo on 2018/11/14.
 */
@RestController
@RequestMapping(value = "/pay")
@Slf4j
public class ControllerForPay {

    @PostMapping("/{type}")
    public void payByType(@PathVariable(value = "type") int type) {
        log.info("进入支付controller入参为{}", type);
        PayWay payWay = null;
        if(type == PayWay.ONLINE.num) {
            payWay = PayWay.OFFLINE;
        }else {
            payWay = PayWay.ONLINE;
        }
        PayWayFactory.getPayServiceImpl(payWay).pay();
    }
}
