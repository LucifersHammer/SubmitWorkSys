package com.jxd.worksys.controller;

import com.jxd.worksys.service.impl.EmpServiceImpl;
import com.jxd.worksys.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private EmpServiceImpl empServiceImpl;

    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        String position = empServiceImpl.login(user);
        if (position == null) {
            position = "wrong";
        }
        return position;
    }
}
