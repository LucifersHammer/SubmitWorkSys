package com.jxd.worksys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private String eno;//员工工号
    private String ename;//员工姓名
    private String sex;//性别
    private String phoneNumber;//联系方式/手机号
    private Integer dno;//所属部门号
    private String position;//职位
    private String pwd;//密码
}
