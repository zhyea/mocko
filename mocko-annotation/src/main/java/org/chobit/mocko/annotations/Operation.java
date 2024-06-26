package org.chobit.mocko.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 应用方法相关信息
 *
 * @author robin
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Operation {


    /**
     * 方法描述信息
     *
     * @return 方法描述信息
     */
    String value();

}
