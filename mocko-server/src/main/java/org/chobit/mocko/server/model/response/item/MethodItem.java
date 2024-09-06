package org.chobit.mocko.server.model.response.item;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MethodItem {


    /**
     * 应用ID
     */
    private String appId;

    /**
     * 类ID
     */
    private String typeId;

    /**
     * 方法ID
     */
    private String methodId;

    /**
     * 类描述
     */
    private String typeAlias;

    /**
     * 类全名
     */
    private String typeFullName;

    /**
     * 方法描述
     */
    private String methodAlias;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 方法返回值类型
     */
    private String responseType;

    /**
     * 方法记录时间
     */
    private LocalDateTime createTime;

    /**
     * 方法上次请求时间
     */
    private LocalDateTime lastRequestTime;

}