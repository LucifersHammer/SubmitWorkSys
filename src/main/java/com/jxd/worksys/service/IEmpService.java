package com.jxd.worksys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.worksys.model.Emp;
import com.jxd.worksys.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//对人进行操作(emp/user)
public interface IEmpService {
    /**
     * 登录功能
     * @param user
     * @return
     */
    String login(User user);

    /**
     * 添加员工
     * @param emp
     * @return
     */
    Boolean addEmp(Emp emp);

    /**
     * 批量删除
     * @param enos
     * @return
     */
    Boolean delBatch(List<String> enos);

    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    Boolean editEmp(Emp emp);

    /**
     * 查询员工信息及部门名称
     * @return
     */
    Map<String, Object> getAllEmpList(Map<String,String> map);

    /**
     * 根据id查一个
     * @param eno
     * @return
     */
    Map<String,Object> selectByEno(String eno);
}
