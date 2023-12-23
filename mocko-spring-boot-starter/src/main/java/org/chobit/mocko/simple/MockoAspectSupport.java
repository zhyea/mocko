package org.chobit.mocko.simple;

import org.chobit.mocko.OperationInvoker;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * Mocko切面支持
 *
 * @author rui.zhang
 */
public class MockoAspectSupport {


    protected Object execute(final OperationInvoker invoker, @Nullable final Object target, Method method, Object[] args) {
        return invoker.invoke();
    }

}