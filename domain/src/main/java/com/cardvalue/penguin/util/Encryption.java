package com.cardvalue.penguin.util;

/**
    * Created by guojia.chen on 2015-09-24 16:15.
    *
    * @Description: 对用户注册、登录、修改密码、忘记密码等操作的密码进行加密，该加密是不可逆的
    *                保证用户信息的安全
    */
public class Encryption {

    /**
     *  注册、忘记密码、修改密码规则:
     *  md5(password)
     * @param password
     * @return
     */
    public static String encryptionUFR(String password){
        //加密后的字符串
        String newstr= "";
        try {
            newstr = MD5Util.md5Encode(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newstr;
    }

    /**
     *  用户登录时的加密规则：
     *  md5(mdf5(password)+cvbaoli+timestamp)+|+timestamp
     * @param password
     * @return
     */
    public static String encryption(String password){
        String timeStamp = timestamp();
        String tempStr = encryptionUFR(password);
        tempStr = tempStr + "cvbaoli" + timeStamp;
        //加密后的字符串
        String newstr= "";
        try {
            newstr = MD5Util.md5Encode(tempStr);
        }catch (Exception e) {
            e.printStackTrace();
        }
        String res = newstr +"|" + timeStamp;
        return res;
    }

    /**
     * 获取10位的时间戳,精确到秒
     * @return
     */
    public static String timestamp(){
        return String.valueOf(System.currentTimeMillis()).substring(0, 10);
    }
}

