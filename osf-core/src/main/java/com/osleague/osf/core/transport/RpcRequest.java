package com.osleague.osf.core.transport;

import java.util.Objects;

/**
 * Created by yif on 2015/9/21.
 */
public class RpcRequest {
    private long id;
    private String targetClass;
    private String targetMethod;
    private Object[] parameterTypes;
    private Objects[] parameters;
    private int timeout;
}
