package com.cardvalue.penguin.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by guojia.chen on 2015-12-29 16:28.
 *
 * @Description:
 */
public class Utility {

    private static DecimalFormat CREDIT_LINE_FORMAT = null;

    private final static DecimalFormat PERCENTAGE_FORMAT = new DecimalFormat("#.##%");

    private final static DecimalFormat DOUBLE_FORMAT = new DecimalFormat("#.##");

    private final static String PERCENTAGE_MARK = "%";

    private final static DateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final static DateFormat SHORT_DATE_FORMAT_IN_CHINESE = new SimpleDateFormat("yyyy年MM月dd日");

    public final static String DURATION_FORMAT_IN_CHINESE = "dd天HH小时mm分钟";

    private final static DateFormat LONG_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private final static DateFormat SHORT_TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private final static String SHORT_KEY_CHARS = "0123456789";

    public static String formatPercentage(double d){
        return PERCENTAGE_FORMAT.format(d);
    }

    public static String formatDouble(double d){
        return DOUBLE_FORMAT.format(d);
    }

    public static String appendPercentageMark(double d){
        return String.valueOf(d) + PERCENTAGE_MARK;
    }

    public static String formatAmount(String input){
        return formatAmount(Double.valueOf(input));
    }

    public static String formatAmount(double input){
        DecimalFormat f = getCreditLineFormat();
        return f.format(input);
    }

    private static DecimalFormat getCreditLineFormat(){
        if(CREDIT_LINE_FORMAT == null){
            CREDIT_LINE_FORMAT = new DecimalFormat("###");
            CREDIT_LINE_FORMAT.setGroupingSize(3);
            CREDIT_LINE_FORMAT.setGroupingUsed(true);
        }
        return CREDIT_LINE_FORMAT;
    }

    public static String formatShortDate(Date date){
        if(date != null){
            return SHORT_DATE_FORMAT.format(date);
        }else{
            return null;
        }
    }

    public static String formatShortDateInChinese(Date date){
        if(date != null){
            return SHORT_DATE_FORMAT_IN_CHINESE.format(date);
        }else{
            return null;
        }
    }

    public static String formatShortTime(Time time){
        if(time != null){
            return SHORT_TIME_FORMAT.format(time);
        }else{
            return null;
        }
    }

    public static String formatLongDate(Date date){
        if(date != null){
            return LONG_DATE_FORMAT.format(date);
        }else{
            return null;
        }
    }

    public static String parseRegionCodeFromMID(String mid){
        return StringUtils.substring(mid, 3, 7);
    }

    public static String parseMccCodeFromMID(String mid){
        return StringUtils.substring(mid, 7, 11);
    }

    public static String mask(String sourceStr, String mask, int start, int end){
        if (sourceStr == null) {
            return null;
        }
        int len = sourceStr.length();
        if(mask == null){
            mask = Constants.DEFAULT_MASK_STAR;
        }
        if (start < 0) {
            start = 0;
        }
        if (start > len) {
            start = len;
        }
        if (end < 0) {
            end = 0;
        }
        if (end > len) {
            end = len;
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sourceStr.substring(0, start));
        while(start < end){
            sb.append(mask);
            start++;
        }
        sb.append(sourceStr.substring(end));
        return sb.toString();
    }

    public final static Date getFutureDate(int interval){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, interval);
        return calendar.getTime();
    }

    public final static java.sql.Date getFutureSqlDate(int interval){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, interval);
        return new java.sql.Date(calendar.getTimeInMillis());
    }

    public final static int getContinusCharLengthFromEnd(String str, char searchChar){
        str = StringUtils.reverse(str);
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) != searchChar){
                break;
            }else{
                i++;
            }
        }
        return i;
    }

    public final static String generateShortKey(int count){
        return RandomStringUtils.random(count, SHORT_KEY_CHARS);
    }

    //获取session
    public static HttpSession session() {
        try {
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            return attr.getRequest().getSession(true); // true == allow create
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 获取两个时间差
     * @param date1 时间1
     * @param date2 时间2
     * @param type 返回类型（d、h、m、s）
     * @return
     */
    public static Long getDateDiff(Date date1,Date date2,String type){

        //计算时间差
        long l= date1.getTime() - date2.getTime();

        //将时间差转换为天、时、分、秒相差
		/*long day = l / (24 * 60 * 60 * 1000);

		long hour = l / (60 * 60 * 1000) - day * 24;

		long min = (l / (60 * 1000)) - day * 24 * 60 - hour * 60;

		long s = l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60; */

        //计算每个天、时、分、秒相差
        long day = l / (24 * 60 * 60 * 1000);

        long hour = l / (60 * 60 * 1000) ;

        long min = (l / (60 * 1000)) ;

        long s = l / 1000;

        //返回
        if(type.equals("d")){

            return day;//返回天

        }else if(type.equals("h")){

            return hour;//返回小时

        }if(type.equals("m")){

            return min;//返回分

        }if(type.equals("now")){

            return s;//返回秒

        }else{
            return 0l;
        }
    }

    /**
     * 创建指定数量的随机字符串验证码
     *
     * @param numberFlag true代表生成纯数字验证码  false代表生成带字母验证码
     * @param length 验证码长度
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890"
                : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            retStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += strTable.charAt(intR);
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);

        return retStr;
    }

    /**
     * 获取中文格式的时间
     * @return
     */
    public static  String getChineseDate(Date date) {
        return new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(date);
    }

    /**
     * 增加或者减去时间天数
     * @param type 1加/0键
     * @param date 时间
     * @param count 修改天数
     * @return
     */
    public static Date addOrMinusDayForDate (int type,Date date,int count) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(type == 1) {
            cal.add(Calendar.DATE, count);
        } else {
            cal.add(Calendar.DATE, -count);
        }
        return cal.getTime();
    }

    //设置错误信息
    public static Map setErrorInfo(String errcode,String errmsg){
        Map<String,String> errorMap = new HashMap<String, String>();
        errorMap.put("errcode",errcode);
        errorMap.put("errmsg",errmsg);
        return errorMap;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println();
    }


    /**
     * 判断ip是否为内网
     * @param ip
     * @return
     */
    public static boolean isInner(String ip){
        String reg = "(10|172|192)\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})";//正则表达式=。 =、懒得做文字处理了、
        Pattern p = Pattern.compile(reg);
        Matcher matcher = p.matcher(ip);
        return matcher.find();
    }

    /**
     * 获取访问的客户端ip
     * @param request
     * @return
     */
    public static String getRemoteIp(HttpServletRequest request){
        String remoteIp = null;
        if (remoteIp==null || remoteIp.length()==0) {
            remoteIp = request.getHeader("x-forwarded-for");
            if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
                remoteIp= request.getHeader("X-Real-IP");
            }
            if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
                remoteIp= request.getHeader("Proxy-Client-IP");
            }
            if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
                remoteIp= request.getHeader("WL-Proxy-Client-IP");
            }
            if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
                remoteIp= request.getHeader("HTTP_CLIENT_IP");
            }
            if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
                remoteIp= request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
                remoteIp= request.getRemoteAddr();
            }
            if (remoteIp == null || remoteIp.isEmpty() || "unknown".equalsIgnoreCase(remoteIp)) {
                remoteIp= request.getRemoteHost();
            }
        }
        //System.out.println("客户端请求ip为:" + remoteIp);
        return remoteIp;
    }

    /**
     * 获取异常的详细信息,以便于保存
     * @param e
     * @return
     */
    public static String getExceptionInfo(Exception e){
        StringWriter sw=new StringWriter();
        e.printStackTrace(new PrintWriter(sw,true));
        return sw.toString();
    }


    /**
     * 标准时间
     * 2015年6月15日14:46:05
     * @param date
     * @return
     */
    public static String formatBasicDate(Date date){
        if(date != null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        }else{
            return null;
        }
    }

    /**
     * 前台汉字乱码转换
     *
     * @param str
     * @return
     */
    public static String transcoding(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");//中文转码
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}