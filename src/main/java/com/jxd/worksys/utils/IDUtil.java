package com.jxd.worksys.utils;

/**
 * @ClassName GetEno
 * @Description TODO
 * @Author shizhihai
 * @Date 2022/9/17
 * @Version 1.0
 */
//获取5位数eno
public class IDUtil {
    private static final long LIMIT = 100000L;
    private static Long last = 0L;

    public static String getID() {
        String res = "";
        // 10 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= last ) {
            id = (last + 1) % LIMIT;
        }
        last = id;
        if (last / 10000 == 0) {
            res = "0" + last;
        } else {
            res = last.toString();
        }
        return "JXD-" + res;
    }
}
