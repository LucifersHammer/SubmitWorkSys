package com.jxd.worksys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Project
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private Integer pno;//项目编号
    private String pname;//项目名称
    private Integer dno;//部门号
}
