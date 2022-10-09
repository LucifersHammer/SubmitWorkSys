package com.jxd.worksys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.worksys.dao.ProjectMapper;
import com.jxd.worksys.dao.WorkMapper;
import com.jxd.worksys.model.Project;
import com.jxd.worksys.model.Work;
import com.jxd.worksys.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName WorkServiceImpl
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@Service
public class WorkServiceImpl implements IWorkService {
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private WorkMapper workMapper;

    /**
     * 添加报工记录
     *
     * @param work
     * @return
     */
    @Override
    public Boolean addOrUpdateWorkRecord(Work work) {
        //提交时间重置
        Date datetime = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        work.setDatetime(dateFormat.format(datetime));
        return workMapper.addOrUpdateWorkRecord(work);
    }


    /**
     * 查询自己的漏报记录，分页
     * map中4个参数
     * current 当前页  size 每页显示大小
     * eno 工号   date 日期
     * @return
     */
    @Override
    public Map<String,Object> selectSelfOmission(Map<String,String> queryMap) {
        String current = queryMap.get("current");
        String size = queryMap.get("size");
        String eno = queryMap.get("eno");
        String date = queryMap.get("date");

        Map<String, Object> map = new HashMap(4);
        if(current != null && size != null){
            IPage<Map<String,Object>> page = new Page(Integer.parseInt(current),Integer.parseInt(size));
            IPage<Map<String,Object>> pageResult = workMapper.selectSelfOmission(page,eno,date);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
        }
        return map;
    }

    /**
     * 查询本部门漏报记录
     *
     * @param queryMap
     * @return
     * @Param queryMap :current,size,eno,date
     */
    @Override
    public Map<String, Object> selectDeptOmission(Map<String, String> queryMap) {
        String current = queryMap.get("current");
        String size = queryMap.get("size");
        String eno = queryMap.get("eno");
        String date = queryMap.get("date");

        Map<String, Object> map = new HashMap(4);
        if(current != null && size != null){
            IPage<Map<String,Object>> page = new Page(Integer.parseInt(current),Integer.parseInt(size));
            IPage<Map<String,Object>> pageResult = workMapper.selectDeptOmission(page,eno,date);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
        }
        return map;
    }


    /**
     * 定时任务添加漏报记录
     *
     * @return
     */
    @Override
    public Boolean addOmission() {
        return workMapper.addOmission();
    }

    /**
     * 条件查询某人的记录，不分页
     *
     * @param eno    员工号
     * @param status 审核状态
     * @return
     */
    @Override
    public List<Map<String, Object>> selectRecordsByEno(String eno, String status) {
        return workMapper.selectRecordsByEno(eno,status);
    }

    /**
     * 部门经理查询本部门下存在未审核的日期和人数
     *
     * @param eno
     * @return
     */
    @Override
    public List<Map<String, Object>> selectNotAudit(String eno) {
        return workMapper.selectNotAudit(eno);
    }

    /**
     * 查询个人所属部门下的项目
     *
     * @param eno
     * @return
     */
    @Override
    public List<Project> selectProject(String eno) {
        return projectMapper.selectProject(eno);
    }

    /**
     * 查询某人的记录
     *
     * @param queryMap
     * @return
     */
    @Override
    public Map<String, Object> getSelfRecord(Map<String, String> queryMap) {
        String current = queryMap.get("current");
        String size = queryMap.get("size");
        String eno = queryMap.get("eno");
        String date = queryMap.get("date");
        String year = queryMap.get("year");
        String tmpPno = queryMap.get("pno");
        Integer pno = 0;
        if (!"".equals(tmpPno)) {
            pno = Integer.parseInt(tmpPno);
        }
        Map<String, Object> map = new HashMap(4);
        if(current != null && size != null){
            IPage<Map<String,Object>> page = new Page(Integer.parseInt(current),Integer.parseInt(size));
            IPage<Map<String,Object>> pageResult = workMapper.selectSelfRecord(page,eno,date,year,pno);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
        }
        return map;
    }

    /**
     * 查询部门的记录
     *
     * @param queryMap
     * @return
     */
    @Override
    public Map<String, Object> getDeptRecord(Map<String, String> queryMap) {
        String current = queryMap.get("current");
        String size = queryMap.get("size");
        String eno = queryMap.get("eno");
        String ename = queryMap.get("ename");
        String startDate = queryMap.get("startDate");
        String endDate = queryMap.get("endDate");

        Map<String, Object> map = new HashMap(4);
        if(current != null && size != null){
            IPage<Map<String,Object>> page = new Page(Integer.parseInt(current),Integer.parseInt(size));
            IPage<Map<String,Object>> pageResult = workMapper.selectDeptRecord(page,eno,ename,startDate,endDate);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
        }
        return map;
    }

    /**
     * 查询该日期是否已经报工
     *
     * @param queryMap eno date
     * @return 未报工(没有记录)或漏报或已报工被退回都是直接返回uid，表示该日期可以被选择
     * 已审核或未审核则把uid设置为-1，表示已报工，不可被选择
     */
    @Override
    public Integer checkAlreadySubmit(Map<String, String> queryMap) {
        Map<String,Object> res = workMapper.selectRecordByEnoAndDate(queryMap);

        Integer uid = null;
        if (res != null){
            String status = (String) res.get("status");
            if ("已审核".equals(status) || "未审核".equals(status)) {
                uid = -1;
            } else {
                uid = (Integer) res.get("uid");
            }
        }
        return uid;
    }

    /**
     * 查询本部门未审核记录
     *
     * @param queryMap
     * @return
     */
    @Override
    public Map<String, Object> getNotAuditRecordByPage(Map<String, String> queryMap) {
        String current = queryMap.get("current");
        String size = queryMap.get("size");
        String mgrEno = queryMap.get("mgrEno");
        String eno = queryMap.get("eno");
        String ename = queryMap.get("ename");
        String date = queryMap.get("date");

        Map<String, Object> map = new HashMap(4);
        if(current != null && size != null){
            IPage<Map<String,Object>> page = new Page(Integer.parseInt(current),Integer.parseInt(size));
            IPage<Map<String,Object>> pageResult = workMapper.selectNotAuditRecordByPage(page,mgrEno,date,eno,ename);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
        }
        return map;
    }

    /**
     * 审核
     *
     * @param auditMap
     * @return
     */
    @Override
    public Boolean audit(Map<String, Object> auditMap) {
        String status = (String) auditMap.get("status");
        List<String> uids = (List<String>) auditMap.get("uids");

        return workMapper.updateStatus(uids,status);
    }
}
