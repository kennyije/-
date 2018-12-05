package com.lyw.factory.impl;

import com.lyw.constans.PayWay;
import com.lyw.factory.KindOfPayFactory;
import com.lyw.service.PayService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2018/12/5.
 */
@Component
public class PayWayFactory implements KindOfPayFactory {

    public static Map<PayWay, PayService> map = new HashMap<>();

    @Override
    public void register(PayWay payWay, PayService payService) {
        map.put(payWay, payService);
    }

    public static <T extends  PayService> T getPayServiceImpl(PayWay payWay) {
        return (T)map.get(payWay);
    }
}
