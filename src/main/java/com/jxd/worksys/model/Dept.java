package com.jxd.worksys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//部门表
public class Dept {
    private Integer dno;
    private String dname;
}
