package org.chobit.mocko.core;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 方法元数据
 *
 * @author rui.zhang
 */
public final class MethodMetadata implements Serializable {


    private static final long serialVersionUID = 8974434856533609672L;


    private transient Class<?> targetType;

    private transient Method method;

    private String configKey;

    private transient Type returnType;


    public String configKey() {
        return this.configKey;
    }


    public MethodMetadata configKey(String configKey) {
        this.configKey = configKey;
        return this;
    }


    public Type returnType() {
        return this.returnType;
    }


    public MethodMetadata returnType(Type returnType) {
        this.returnType = returnType;
        return this;
    }


    public Class<?> targetType() {
        return this.targetType;
    }


    public MethodMetadata targetType(Class<?> targetType) {
        this.targetType = targetType;
        return this;
    }


    public Method method() {
        return this.method;
    }


    public MethodMetadata method(Method method) {
        this.method = method;
        return this;
    }

}
