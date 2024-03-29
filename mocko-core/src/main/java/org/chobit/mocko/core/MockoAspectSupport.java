package org.chobit.mocko.core;

import org.chobit.commons.utils.JsonKit;
import org.chobit.mocko.core.annotations.Mocko;
import org.chobit.mocko.core.annotations.MockoClient;
import org.chobit.mocko.core.contants.ResponseCode;
import org.chobit.mocko.core.exception.MockoException;
import org.chobit.mocko.core.model.ArgInfo;
import org.chobit.mocko.core.model.MethodMeta;
import org.chobit.mocko.annotations.ClassInfo;
import org.chobit.mocko.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * Mocko切面支持
 *
 * @author rui.zhang
 */
public class MockoAspectSupport {


    private static final Logger logger = LoggerFactory.getLogger(MockoAspectSupport.class);

    protected Object execute(OperationInvoker invoker, Object target, Method method, Object[] args) {

        MethodMeta methodMeta = null;
        try {
            methodMeta = parseMethodMetadata(target, method, args);
            return requestMockoServer(methodMeta);
        } catch (Exception e) {
            logger.error("request mocko server error, method info:{}", JsonKit.toJson(method));
            throw new MockoException(ResponseCode.REQUEST_MOCKO_SERVER_ERROR);
        }
    }


    private Object requestMockoServer(MethodMeta methodMeta) {

        return JsonKit.fromJson("{}", methodMeta.getReturnType());
    }


    /**
     * 提取方法信息
     *
     * @param target 执行方法的对象
     * @param method 执行的方法
     * @param args   参数
     * @return 方法信息
     */
    private MethodMeta parseMethodMetadata(Object target, Method method, Object[] args) {

        String className = target.getClass().getCanonicalName();
        String classAlias = this.parseClassAlias(target.getClass());

        String methodName = method.getName();
        String methodAlias = this.parseMethodAlias(method);

        List<ArgInfo> argList = takeArgList(args);

        Class<?> returnType = method.getReturnType();

        MethodMeta methodMeta = new MethodMeta();
        methodMeta.setClassName(className);
        methodMeta.setClassAlias(classAlias);
        methodMeta.setMethodName(methodName);
        methodMeta.setMethodAlias(methodAlias);
        methodMeta.setArgs(argList);
        methodMeta.setReturnType(returnType);

        return methodMeta;
    }


    /**
     * 解析Class别名
     *
     * @param clazz Class实例
     * @return Class别名
     */
    private String parseClassAlias(Class<?> clazz) {

        MockoClient mockoClient = clazz.getAnnotation(MockoClient.class);
        if (null != mockoClient) {
            return mockoClient.value();
        }

        Mocko mockoClass = clazz.getAnnotation(Mocko.class);
        if (null != mockoClass) {
            return mockoClass.value();
        }

        ClassInfo classInfo = clazz.getAnnotation(ClassInfo.class);
        if (null != classInfo) {
            return classInfo.value();
        }

        return "";
    }


    /**
     * 解析方法别名
     *
     * @param method Method 实例
     * @return 方法别名
     */
    private String parseMethodAlias(Method method) {

        Mocko mocko = method.getAnnotation(Mocko.class);
        if (null != mocko) {
            return mocko.value();
        }

        Operation opr = method.getAnnotation(Operation.class);
        if (null != opr) {
            return opr.value();
        }

        return "";
    }


    /**
     * 提取参数信息
     *
     * @param args 参数集合
     * @return 参数信息集合
     */
    private List<ArgInfo> takeArgList(Object[] args) {
        List<ArgInfo> result = new LinkedList<>();
        if (args.length == 0) {
            return result;
        }

        for (int i = 1; i <= args.length; i++) {
            Object o = args[i];

            ArgInfo a = new ArgInfo();
            a.setArgClass(o.getClass().getCanonicalName());
            a.setArgName("arg" + i);

            result.add(a);
        }
        return result;
    }

}
