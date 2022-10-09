package com.jxd.worksys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.worksys.dao.EmpMapper;
import com.jxd.worksys.dao.UserMapper;
import com.jxd.worksys.model.Emp;
import com.jxd.worksys.service.IEmpService;
import com.jxd.worksys.utils.IDUtil;
import com.jxd.worksys.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpService
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public String login(User user) {
        return userMapper.selectPosition(user);
    }

    /**
     * 添加员工
     *
     * @param emp
     * @return
     */
    @Override
    public Boolean addEmp(Emp emp) {
        //指定eno
        emp.setEno(IDUtil.getID());
        return empMapper.addEmp(emp) && userMapper.addUser(emp);
    }

    /**
     * 批量删除
     *
     * @param enos
     * @return
     */
    @Override
    public Boolean delBatch(List<String> enos) {
        return empMapper.delBatch(enos) && userMapper.delBatch(enos);
    }

    /**
     * 修改员工信息
     *
     * @param emp
     * @return
     */
    @Override
    public Boolean editEmp(Emp emp) {
        return empMapper.updateEmp(emp) && userMapper.updateUser(emp);
    }

    /**
     * 查询员工信息及部门名称
     *
     * @param queryMap
     * @return
     */
    @Override
    public Map<String, Object> getAllEmpList(Map<String,String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String ename = queryMap.get("ename");
        String tmpdno = queryMap.get("dno");
        Integer dno = null;
        if(!"".equals(tmpdno)){
            dno = Integer.parseInt(tmpdno);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Map<String,Object>> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = empMapper.getAllEmpList(pages,ename,dno);
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
     * 根据id查一个
     *
     * @param eno
     * @return
     */
    @Override
    public Map<String, Object> selectByEno(String eno) {
        return empMapper.selectByEno(eno);
    }
}
