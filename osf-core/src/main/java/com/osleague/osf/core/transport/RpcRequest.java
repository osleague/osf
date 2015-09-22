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


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(String targetClass) {
        this.targetClass = targetClass;
    }

    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }

    public Object[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Object[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Objects[] getParameters() {
        return parameters;
    }

    public void setParameters(Objects[] parameters) {
        this.parameters = parameters;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
