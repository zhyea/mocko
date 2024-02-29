package org.chobit.mocko.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * model属性描述注解
 *
 * @author rui.zhang
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AppModelProperty {


    /**
     * property描述信息
     */
    String value();

}
