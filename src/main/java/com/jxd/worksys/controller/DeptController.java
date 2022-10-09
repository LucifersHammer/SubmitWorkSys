package com.jxd.worksys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.worksys.model.Dept;
import com.jxd.worksys.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DeptController
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/21
 * @Version 1.0
 */
@RestController
public class DeptController {
    @Autowired
    private IDeptService deptService;

    //添加或修改部门信息
    @RequestMapping("insertOrUpdateDept")
    public Boolean insertOrUpdateDept(@RequestBody Dept dept){
        return deptService.insertOrUpdate(dept);
    }

    //分页查询部门信息
    @RequestMapping("getDeptByPage")
    public Map<String,Object> getDept(@RequestBody Map<String,String> queryMap){
        Integer current = Integer.parseInt(queryMap.get("page"));
        Integer limit = Integer.parseInt(queryMap.get("limit"));
        String dname = queryMap.get("dname");
        IPage<Dept> page = new Page<>(current,limit);
        IPage<Dept> pageResult = deptService.selectDept(page,dname);
        Map<String,Object> map = new HashMap<>();
        map.put("count",pageResult.getTotal());
        map.put("data",pageResult.getRecords());
        map.put("code",0);
        return map;
    }

    //批量删除部门信息
    @RequestMapping("delDeptBatch")
    public String delBatch(@RequestBody List<Integer> dnos) {
        return deptService.delBatch(dnos);
    }

    //下拉框选择部门
    @RequestMapping("getAllDept")
    public List<Dept> getAllDept() {
        return deptService.selectAllDept();
    }

    //查一个
    @RequestMapping("getDeptByDno/{dno}")
    public Dept getOne(@PathVariable Integer dno) {
        return deptService.selectOne(dno);
    }
}
