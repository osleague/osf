package com.osleague.osf.tcp.service.impl;

import com.osleague.osf.core.annotation.RpcService;
import com.osleague.osf.tcp.service.HelloService;

/**
 * Created by Yif Zhan on 2015/9/22.
 */
@RpcService(referrer = HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name;
    }
}
