package com.jxd.worksys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SubmitWorkSysApplication
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jxd.worksys.dao")
public class SubmitWorkSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubmitWorkSysApplication.class,args);
    }
}
