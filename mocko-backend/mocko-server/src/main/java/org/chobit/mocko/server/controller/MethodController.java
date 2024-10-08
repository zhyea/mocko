package org.chobit.mocko.server.controller;

import org.chobit.commons.model.response.PageResult;
import org.chobit.mocko.server.model.request.*;
import org.chobit.mocko.server.model.response.item.MethodItem;
import org.chobit.mocko.server.service.MethodService;
import org.chobit.spring.autoconfigure.rw.ResponseWrapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 方法相关接口
 *
 * @author robin
 */
@ResponseWrapper
@RestController
@RequestMapping("/admin/method")
public class MethodController {


    @Resource
    private MethodService methodService;


    /**
     * 获取方法信息
     *
     * @param request 查询请求
     * @return 方法信息
     */
    @PostMapping("/get")
    public MethodItem getByMethodId(@RequestBody @Validated MethodIdRequest request) {
        return methodService.getByMethodId(request.getMethodId());
    }


    /**
     * 分页查询方法信息
     *
     * @param request 方法分页查询请求
     * @return 方法信息
     */
    @PostMapping("/page-list")
    public PageResult<MethodItem> findMethodsInPage(@RequestBody @Validated MethodPageRequest request) {
        return methodService.findInPage(request);
    }


    /**
     * 修改方法信息
     *
     * @param request 更新请求
     * @return 是否更新成功
     */
    @PostMapping("/modify")
    public boolean modify(@RequestBody @Validated MethodModifyRequest request) {
        return methodService.modify(request);
    }


    /**
     * 删除方法记录
     *
     * @param request 删除请求
     * @return 是否删除成功
     */
    @PostMapping("/delete")
    public boolean delete(@RequestBody @Validated MethodDeleteRequest request) {
        return methodService.delete(request);
    }
}
