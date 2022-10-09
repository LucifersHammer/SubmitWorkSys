package com.jxd.worksys.job;

import com.jxd.worksys.service.IWorkService;
import com.jxd.worksys.utils.HolidayUtil;
import org.jetbrains.annotations.NotNull;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName AddOmission
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/19
 * @Version 1.0
 */
//定时任务 添加漏报记录
public class AddOmission extends QuartzJobBean {
    @Autowired
    private IWorkService workService;
    @Override
    protected void executeInternal(@NotNull JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        if (HolidayUtil.isHoliday(dateFormat.format(date)) == 1) {
            workService.addOmission();
        }

    }
}
