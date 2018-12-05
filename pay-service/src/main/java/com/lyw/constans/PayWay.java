package com.lyw.constans;

/**
 * Created by Lenovo on 2018/11/14.
 */
public enum PayWay {
    ONLINE(0),OFFLINE(1);
    public int num;
    PayWay(int type){
        this.num = type;
    }
}
