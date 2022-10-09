package com.jxd.worksys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Work
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//报工信息
public class Work {
    private Integer uid;//id,无特殊意义
    private String eno;//员工工号
    private String date;//报工日期(简略)
    private String datetime;//报工时间(详细)
    private String attendance;//上班/请假/调休
    private Integer workload;//工作量
    private Double overtime;//加班时间
    private String instruction;//工作描述
    private Integer pno;//项目编号
    private String status;//审核状态  (漏报)->未审核->退回->已审核
}
