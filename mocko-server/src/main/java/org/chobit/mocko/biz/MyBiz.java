package org.chobit.mocko.biz;

import org.springframework.stereotype.Component;

/**
 * 测试业务类
 *
 * @author robin
 */
@Component
public class MyBiz {


    public String ping() {
        return "pong";
    }

}
