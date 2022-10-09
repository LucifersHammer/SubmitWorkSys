package com.jxd.worksys.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.worksys.model.Project;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {

    /**
     * 获取项目列表
     * @return
     */
    List<Project> selectProject(String eno);

    /**
     * 用于查询部门下是否有项目
     * @return
     */
    Integer[] selDno();
}
