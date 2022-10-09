package com.jxd.testUtil;

import com.jxd.worksys.utils.HolidayUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName HolidayTest
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/10/8
 * @Version 1.0
 */
public class HolidayTest {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(HolidayUtil.isHoliday(dateFormat.format(date)));
        System.out.println(HolidayUtil.isHoliday("2022-10-10"));
    }
}
