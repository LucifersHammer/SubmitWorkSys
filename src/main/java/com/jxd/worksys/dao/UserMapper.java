package com.jxd.worksys.dao;

import com.jxd.worksys.model.Emp;
import com.jxd.worksys.vo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 用于登录，管理员身份特殊，不能与emp表通用
     * @param user
     * @return
     */
    String selectPosition(User user);

    /**
     * 添加员工部分信息 eno,pwd,position
     * @param emp
     * @return
     */
    Boolean addUser(Emp emp);

    /**
     * 批量删除
     * @param enos
     * @return
     */
    Boolean delBatch(@Param("enos") List<String> enos);

    /**
     * 修改该部分的员工信息
     * @param emp
     * @return
     */
    Boolean updateUser(Emp emp);
}
