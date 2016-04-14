package com.cardvalue.penguin.util;

/**
 * Created by guojia.chen on 2016-01-16 13:28.
 *
 * @Description:
 */
public class StringHelp {

    /**
     * 判断字符串是否为空
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmptyString(String str)
    {
        return str == null || str.trim().length() == 0;
    }
}
