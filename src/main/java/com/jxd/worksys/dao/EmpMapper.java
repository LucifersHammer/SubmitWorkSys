package com.jxd.worksys.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.worksys.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    /**
     * 添加员工在emp表中的相关部分信息
     * @param emp
     * @return
     */
    Boolean addEmp(Emp emp);

    /**
     * 批量删除
     * @param enos
     * @return
     */
    Boolean delBatch(@Param("enos") List<String> enos);

    /**
     * 查询员工信息及部门名称
     * @return
     */
    IPage<Map<String,Object>> getAllEmpList(IPage<Map<String,Object>> page,
                                             String ename,
                                             Integer dno);

    /**
     * 根据id查一个
     * @param eno
     * @return
     */
    Map<String,Object> selectByEno(String eno);

    /**
     * 修改该部分的员工信息
     * @param emp
     * @return
     */
    Boolean updateEmp(Emp emp);

    /**
     * 用于检查部门下是否有员工
     * @return
     */
    Integer[] selDno();
}
