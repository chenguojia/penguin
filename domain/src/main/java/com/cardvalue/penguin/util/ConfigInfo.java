package com.cardvalue.penguin.util;

import java.util.ResourceBundle;

/**
 * Created by guojia.chen on 2016-01-12 17:06.
 *
 * @Description:
 */
public class ConfigInfo {

    private static ResourceBundle cache = null;
    static{
        try {
            //读取environment.properties配置文件
            cache = ResourceBundle.getBundle("environment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取指定key的值
     * @param key
     * @return
     * @Description:
     * @date 2015-12-2 下午09:53:34
     * @version 1.0
     * @author guojia.chen
     */
    public static String getValue(String key){
        String value = cache.getString(key);
        System.out.println(value);
        return value;
    }

    public static void main(String[] args) {
        getValue("X-CRM-Version");
    }

}