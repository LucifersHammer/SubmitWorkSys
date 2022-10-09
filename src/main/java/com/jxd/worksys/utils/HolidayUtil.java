package com.jxd.worksys.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @ClassName HolidayUtil
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/10/8
 * @Version 1.0
 */
public class HolidayUtil {
    /**
     * 获取日期信息
     */
    private static final String GET_URL = "http://timor.tech/api/holiday/info/";

    /**
     * 判断日期是否为节假日
     *
     * @param date
     * @return {"code":0,"type":{"type":2,"name":"国庆节","week":5},"holiday":{"holiday":true,"name":"国庆节","wage":2,"date":"2022-10-07","rest":1}}
     */
    public static int isHoliday(String date) {
        String res;
        try {
            res = HttpRequestUtil.sendGet(GET_URL + date);
            JSONObject jsonObject = JSONObject.parseObject(res);
            if (jsonObject.get("holiday") == null) {
                //正常上班
                return 1;
            } else {
                //拿到第一层holiday
                JSONObject holiday = JSONObject.parseObject(jsonObject.get("holiday").toString());
                //拿到是否为holiday的结果
                String isHoliday = holiday.get("holiday").toString();
                if ("true".equals(isHoliday)) {
                    //是假期
                    return 0;
                } else {
                    //正常上班
                    return 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
