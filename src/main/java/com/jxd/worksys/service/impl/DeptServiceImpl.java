package com.jxd.worksys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.worksys.dao.DeptMapper;
import com.jxd.worksys.dao.EmpMapper;
import com.jxd.worksys.dao.ProjectMapper;
import com.jxd.worksys.model.Dept;
import com.jxd.worksys.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/21
 * @Version 1.0
 */
@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private ProjectMapper projectMapper;
    /**
     * 批量删除部门
     *
     * @param dnos
     * @return
     */
    @Override
    public String delBatch(List<Integer> dnos) {
        Integer[] ednos = empMapper.selDno();
        Integer[] pdnos = projectMapper.selDno();
        //记录原始要删除的个数
        int length = dnos.size();
        //去掉不能删的部门
        for (Integer edno : ednos) {
            dnos.remove(edno);
        }
        for (Integer pdno : pdnos) {
            dnos.remove(pdno);
        }

        if (dnos.size() == 0){
            return "none";
        } else {
            Integer num = deptMapper.delBatch(dnos);
            if (num == 0){
                return "error";
            } else if (num == length) {
                return "success";
            } else {
                return "warn";
            }
        }
    }

    /**
     * 增加或修改部门信息
     *
     * @param dept
     * @return
     */
    @Override
    public Boolean insertOrUpdate(Dept dept) {
        return deptMapper.insertOrUpdate(dept);
    }

    /**
     * 查询部门信息
     *
     * @param dname
     * @return
     */
    @Override
    public IPage<Dept> selectDept(IPage<Dept> page,String dname) {
        return deptMapper.selectDept(page,dname);
    }

    /**
     * 用于下拉框选择部门
     *
     * @return
     */
    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectAllDept();
    }

    /**
     * 查一个
     *
     * @param dno
     * @return
     */
    @Override
    public Dept selectOne(Integer dno) {
        return deptMapper.selectOne(dno);
    }
}
