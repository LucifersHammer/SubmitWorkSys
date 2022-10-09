package com.jxd.worksys.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.worksys.model.Project;
import com.jxd.worksys.model.Work;

import java.util.List;
import java.util.Map;

public interface WorkMapper {
    /**
     * 添加报工记录
     * @param work
     * @return
     */
    Boolean addOrUpdateWorkRecord(Work work);

    //删

    /**
     * 根据员工号和日期查询漏报记录(+部门名称、项目名称)，分页
     * @param page
     * @param eno
     * @param date
     * @return
     */
    IPage<Map<String,Object>> selectSelfOmission(IPage<Map<String,Object>> page,
                                             String eno,
                                             String date);

    /**
     * 查询本部门漏报记录
     * @param page
     * @param eno
     * @param date
     * @return
     */
    IPage<Map<String,Object>> selectDeptOmission(IPage<Map<String,Object>> page,
                                                 String eno,
                                                 String date);

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
     * 查询某人的记录
     * @param page
     * @param eno
     * @param date
     * @param year
     * @param pno
     * @return
     */
    IPage<Map<String,Object>> selectSelfRecord(IPage<Map<String,Object>> page,
                                               String eno,
                                               String date,
                                               String year,
                                               Integer pno);


    IPage<Map<String,Object>> selectDeptRecord(IPage<Map<String,Object>> page,
                                               String eno,
                                               String ename,
                                               String startDate,
                                               String endDate);

    /**
     * 查询是否已经报工
     * @param queryMap :eno date
     * @return
     */
    Map<String,Object> selectRecordByEnoAndDate(Map<String,String> queryMap);

    /**
     * 查询部门未审核记录
     * @param page
     * @param mgrEno
     * @param date
     * @param eno
     * @param ename
     * @return
     */
    IPage<Map<String,Object>> selectNotAuditRecordByPage(IPage<Map<String,Object>> page,
                                                   String mgrEno,
                                                   String date,
                                                   String eno,
                                                   String ename);

    /**
     * 审核
     * @param uids
     * @param status
     * @return
     */
    Boolean updateStatus(List<String> uids,String status);
}
