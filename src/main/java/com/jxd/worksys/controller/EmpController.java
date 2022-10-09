package com.jxd.worksys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.worksys.model.Emp;
import com.jxd.worksys.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@RestController
public class EmpController {
    @Autowired
    private IEmpService empService;

    @RequestMapping("/addEmp")
    public Boolean addEmp(@RequestBody Emp emp) {
        return empService.addEmp(emp);
    }

    @RequestMapping("/delEmpBatch")
    public Boolean delBatch(@RequestBody List<String> enos) {
        return empService.delBatch(enos);
    }

    @RequestMapping("/editEmp")
    public Boolean editEmp(@RequestBody Emp emp) {
        return empService.editEmp(emp);
    }

    /**
     *
     * @param map 四个参数  limit  page  ename  dno
     * @return  返回数据中包括 data:所有列表数据， count总条数
     */
    @RequestMapping("/getEmpByPage")
    public Map<String,Object> list(@RequestBody Map<String,String> map){
        return empService.getAllEmpList(map);
    }

    @RequestMapping("/getEmpByEno/{eno}")
    public Map<String, Object> getEmpByEno(@PathVariable String eno) {
        return empService.selectByEno(eno);
    }
}
