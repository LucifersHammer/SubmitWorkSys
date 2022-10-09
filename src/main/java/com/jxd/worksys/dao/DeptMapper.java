package com.jxd.worksys.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.worksys.model.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    /**
     * 批量删除部门
     * @param dnos
     * @return
     */
    Integer delBatch(@Param("dnos") List<Integer> dnos);

    /**
     * 增加或修改部门信息
     * @param dept
     * @return
     */
    Boolean insertOrUpdate(Dept dept);

    /**
     * 分页查询部门信息
     * @param dname
     * @return
     */
    IPage<Dept> selectDept(IPage<Dept> page,String dname);

    /**
     * 用于下拉框选择部门
     * @return
     */
    List<Dept> selectAllDept();

    /**
     * 查一个
     * @param dno
     * @return
     */
    Dept selectOne(Integer dno);
}
