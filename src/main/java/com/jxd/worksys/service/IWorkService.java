package com.jxd.worksys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.worksys.model.Project;
import com.jxd.worksys.model.Work;

import java.util.List;
import java.util.Map;

//工作相关操作
public interface IWorkService {
    /**
     * 添加报工记录
     * @param work
     * @return
     */
    Boolean addOrUpdateWorkRecord(Work work);


    /**
     * 根据员工号和日期查询漏报记录(+部门名称、项目名称)，分页
     * map中4个参数
     * current 当前页  size 每页显示大小
     * eno 工号   date 日期
     * @return
     */
    Map<String,Object> selectSelfOmission(Map<String,String> queryMap);

    /**
     * 查询本部门漏报记录
     * @Param queryMap :current,size,eno,date
     * @return
     */
    Map<String,Object> selectDeptOmission(Map<String,String> queryMap);

    /**
     * 定时任务添加漏报记录
     * @return
     */
    Boolean addOmission();

    /**
     * 条件查询某人的记录，不分页
     * @param eno 员工号
     * @param status 审核状态
     * @return
     */
    List<Map<String,Object>> selectRecordsByEno(String eno,String status);

    /**
     * 部门经理查询本部门下存在未审核的日期和人数
     * @param eno
     * @return
     */
    List<Map<String,Object>> selectNotAudit(String eno);

    /**
     * 查询个人所属部门下的项目
     * @param eno
     * @return
     */
    List<Project> selectProject(String eno);

    /**
     * 查询某人的记录
     * @param queryMap
     * @return
     */
    Map<String,Object> getSelfRecord(Map<String,String> queryMap);

    /**
     * 查询部门的记录
     * @param queryMap
     * @return
     */
    Map<String,Object> getDeptRecord(Map<String,String> queryMap);

    /**
     * 查询该日期是否已经报工
     * @param queryMap
     * @return 未报工或已报工被退回都是直接返回uid，表示该日期可以被选择
     *          已审核或未审核则把uid设置为-1，表示已报工，不可被选择
     */
    Integer checkAlreadySubmit(Map<String,String> queryMap);

    /**
     * 查询本部门未审核记录
     * @param queryMap
     * @return
     */
    Map<String,Object> getNotAuditRecordByPage(Map<String,String> queryMap);

    /**
     * 审核
     * @param auditMap
     * @return
     */
    Boolean audit(Map<String,Object> auditMap);
}
