package com.jxd.worksys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.worksys.model.Project;
import com.jxd.worksys.model.Work;
import com.jxd.worksys.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName WorkController
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/18
 * @Version 1.0
 */
@RestController
public class WorkController {
    @Autowired
    private IWorkService workService;

    //添加报工记录
    @RequestMapping("/addOrUpdateWorkRecord")
    public Boolean addOrUpdateWorkRecord(@RequestBody Work work) {
        return workService.addOrUpdateWorkRecord(work);
    }

    //查询项目
    @RequestMapping("/getProject/{eno}")
    public List<Project> getProject(@PathVariable("eno") String eno) {
        return workService.selectProject(eno);
    }

    //某人根据条件查报工记录,分页
    @RequestMapping("/getSelfRecord")
    public Map<String,Object> getSelfRecord(@RequestBody Map<String,String> queryMap) {
        return workService.getSelfRecord(queryMap);
    }


    //个人查漏报记录，分页
    @RequestMapping("/getSelfOmission")
    public Map<String,Object> getSelfOmission(@RequestBody Map<String,String> queryMap) {
        return workService.selectSelfOmission(queryMap);
    }

    //查本部门漏报记录
    @RequestMapping("/getDeptOmission")
    public Map<String,Object> getDeptOmission(@RequestBody Map<String,String> queryMap) {
        return workService.selectDeptOmission(queryMap);
    }

    //根据条件查记录，不分页,用于首页展示
    @RequestMapping("getRecordsByEno")
    public List<Map<String,Object>> getRecordsByEno(@RequestBody Map<String,String> queryMap){
        String eno = queryMap.get("eno");
        String status = queryMap.get("auditStatus");
        return workService.selectRecordsByEno(eno,status);
    }

    //部门经理查询本部门下未审核人数和日期,不分页，仅用于首页展示
    @RequestMapping("getNotAudit/{eno}")
    public List<Map<String,Object>> getNotAudit(@PathVariable String eno){
        return workService.selectNotAudit(eno);
    }

    //查询本部门所有记录
    @RequestMapping("/getDeptRecord")
    public Map<String,Object> getDeptRecord(@RequestBody Map<String,String> queryMap) {
        return workService.getDeptRecord(queryMap);
    }

    //检查所选日期
    @RequestMapping("/checkAlreadySubmit")
    public Integer checkAlreadySubmit(@RequestBody Map<String,String> queryMap) {
        return workService.checkAlreadySubmit(queryMap);
    }

    //分页查询未审核记录
    @RequestMapping("getNotAuditRecordByPage")
    public Map<String,Object> getNotAuditRecordByPage(@RequestBody Map<String,String> queryMap) {
        return workService.getNotAuditRecordByPage(queryMap);
    }

    //审核
    @RequestMapping("audit")
    public Boolean audit(@RequestBody Map<String,Object> auditMap) {
        return workService.audit(auditMap);
    }
}
