package com.lyw.service.impl;

import com.lyw.constans.PayWay;
import com.lyw.factory.impl.PayWayFactory;
import com.lyw.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2018/11/14.
 */
@Service
@Slf4j
public class PayOffline extends PayService implements InitializingBean{
    public void pay() {
        log.info("进入线下放款service");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PayWayFactory.map.put(PayWay.OFFLINE, this);
    }
}
