package com.jxd.worksys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//仅用作登录，管理员身份特殊，只能单独列出
public class User {
    private String eno;
    private String pwd;
    private String position;
}
