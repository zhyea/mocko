package org.chobit.mocko.server.service.mapper;

import org.apache.ibatis.annotations.*;
import org.chobit.mocko.server.model.request.MethodRuleAddRequest;
import org.chobit.mocko.server.model.request.MethodRuleModifyRequest;
import org.chobit.mocko.server.model.response.item.MethodRuleItem;

import java.util.List;

/**
 * @author robin
 */
@Mapper
public interface MethodRuleMapper {


    /**
     * 新增方法规则信息
     *
     * @param req      规则信息
     * @param operator 操作人
     */
    @Insert({
            "insert into m_method_rule (method_id, rule_title, expression, response, switch_flag, remark, operator_code)",
            "values",
            "(#{item.methodId}, #{item.ruleTitle}, ",
            "#{item.expression, typeHandler=org.chobit.mocko.server.config.mybatis.NullTypeHandler}, ",
            "#{item.response}, #{item.switchFlag}, ",
            "#{item.remark, typeHandler=org.chobit.mocko.server.config.mybatis.NullTypeHandler}, #{operator})"
    })
    @Options(useGeneratedKeys = true)
    boolean add(@Param("item") MethodRuleAddRequest req, @Param("operator") String operator);


    /**
     * 方法规则更新
     *
     * @param req      规则信息
     * @param operator 操作人
     * @return 是否更新成功
     */
    @Update({
            "update m_method_rule set ",
            "rule_title=#{item.ruleTitle}, ",
            "expression=#{item.expression, typeHandler=org.chobit.mocko.server.config.mybatis.NullTypeHandler}, ",
            "response=#{item.response}, ",
            "remark=#{item.remark, typeHandler=org.chobit.mocko.server.config.mybatis.NullTypeHandler}, ",
            "switch_flag=#{item.switchFlag}, operator_code=#{operator}",
            "where id=#{item.id}"
    })
    boolean modify(@Param("item") MethodRuleModifyRequest req, @Param("operator") String operator);


    /**
     * 根据方法ID查询规则信息
     *
     * @param methodId 方法ID
     * @return 方法返回值规则信息
     */
    @Select({"select id as rule_id, * from m_method_rule ",
            "where method_id=#{methodId} and deleted=0 order by id desc"})
    List<MethodRuleItem> fidByMethodId(@Param("methodId") String methodId);


    /**
     * 删除方法对应的规则记录
     *
     * @param methodId 方法ID
     * @return 删除的条数
     */
    @Delete({"delete from m_method_rule where method_id=#{methodId}"})
    int deleteByMethodId(@Param("methodId") String methodId);


    /**
     * 根据ID删除规则记录
     *
     * @param id 规则ID
     * @return 是否删除成功
     */
    @Delete({"delete from m_method_rule where id=#{id}"})
    boolean deleteById(@Param("id") int id);


    /**
     * 重置请求次数和最后请求时间
     *
     * @param id 规则ID
     */
    @Update({"update m_method_rule set ",
            "last_request_time=now(), request_count=request_count+1 ",
            "where id=#{id}"})
    void resetRequestInfo(@Param("id") int id);


    /**
     * 根据ID查询规则信息
     *
     * @param id 规则ID
     * @return 规则信息
     */
    @Select({"select id as rule_id, * from m_method_rule where id=#{id}"})
    MethodRuleItem getById(@Param("id") int id);


    /**
     * 切换规则开关
     *
     * @param id         规则ID
     * @param switchFlag 开关状态
     * @return 是否切换成功
     */
    @Update({"update m_method_rule set switch_flag=#{switchFlag} where id=#{id}"})
    boolean switchRule(@Param("id") int id, @Param("switchFlag") Integer switchFlag);
}
