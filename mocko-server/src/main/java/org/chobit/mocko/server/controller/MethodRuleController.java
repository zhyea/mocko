package org.chobit.mocko.server.controller;

import org.chobit.mocko.server.model.request.MethodIdRequest;
import org.chobit.mocko.server.model.request.MethodRuleAddRequest;
import org.chobit.mocko.server.model.request.MethodRuleIdRequest;
import org.chobit.mocko.server.model.request.MethodRuleModifyRequest;
import org.chobit.mocko.server.model.response.item.MethodRuleItem;
import org.chobit.mocko.server.service.MethodRuleService;
import org.chobit.spring.autoconfigure.rw.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 方法规则相关接口
 *
 * @author robin
 */
@ResponseWrapper
@RestController
@RequestMapping("/admin/method/rule")
public class MethodRuleController {


	private final MethodRuleService methodRuleService;


	@Autowired
	public MethodRuleController(MethodRuleService methodRuleService) {
		this.methodRuleService = methodRuleService;
	}


	/**
	 * 新增方法规则
	 *
	 * @param request 方法规则新增请求
	 * @return 是否新增成功
	 */
	@PostMapping("/add")
	public boolean add(@RequestBody @Validated MethodRuleAddRequest request) {
		return methodRuleService.add(request);
	}


	/**
	 * 修改方法规则
	 *
	 * @param request 方法规则修改请求
	 * @return 是否修改成功
	 */
	@PostMapping("/modify")
	public boolean modify(@RequestBody @Validated MethodRuleModifyRequest request) {
		return methodRuleService.modify(request);
	}


	/**
	 * 删除方法规则
	 *
	 * @param request 方法规则ID请求
	 * @return 是否删除成功
	 */
	@PostMapping("/delete")
	public boolean delete(@RequestBody @Validated MethodRuleIdRequest request) {
		return methodRuleService.delete(request.getId());
	}


	/**
	 * 查询方法规则列表
	 *
	 * @param request 方法ID相关请求
	 * @return 方法规则集合
	 */
	@PostMapping("/list")
	public List<MethodRuleItem> findAll(@RequestBody @Validated MethodIdRequest request) {
		return methodRuleService.findByMethodId(request.getMethodId());
	}

}
