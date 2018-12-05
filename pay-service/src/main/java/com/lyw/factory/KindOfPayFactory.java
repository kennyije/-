package com.lyw.factory;

import com.lyw.constans.PayWay;
import com.lyw.service.PayService;

/**
 * Created by Lenovo on 2018/11/14.
 */
public interface KindOfPayFactory {
    public void register(PayWay payWay, PayService payService);
}
