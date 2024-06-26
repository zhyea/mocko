package org.chobit.mocko.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类信息
 *
 * @author robin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassDesc {


    /**
     * 类信息
     *
     * @return 类信息
     */
    String value();


    /**
     * 类别名
     *
     * @return 类别名
     */
    String alias() default "";

}
