package com.cardvalue.penguin.util;

/**
 * Created by guojia.chen on 2015-12-29 16:30.
 *
 * @Description:
 */
public class Constants {

    public final static String SESSION_KEY_WECHAT_OPEN_ID = "wechat_open_id" +
            "";
    public final static String SESSION_KEY_USER = "login_user";
    public final static String SESSION_KEY_USER_INFO = "login_user_info";
    public final static String SESSION_KEY_SALES = "login_sales";
    public final static String SESSION_KEY_MERCHANT = "login_merchant";
    public final static String SESSION_KEY_TOKEN = "token";

    public final static String SESSION_KEY_NEW_MERCHANT = "login_new_merchant";


    //用户来源
    //系统创建
    public final static int USER_SOURCE_SYSTEM_CREATED = 1;
    //其他用户创建
    public final static int USER_SOURCE_USER_ADD = 2;
    //扫描 二维码
    public final static int USER_SOURCE_SCAN_QRCODE = 3;
    //用户自添加
    public final static int USER_SOURCE_SUBSCRIBE = 4;

    //标注发送相同个请求的用户来源
    public final static String SOURCE_TYPE_SALES = "sales";
    public final static String SOURCE_TYPE_MERCHANT = "merchant";

    public final static int TYPE_LEADS = 1;
    public final static int TYPE_TASK = 2;

    //数据库里线索和任务的序列编号
    public final static String SEQUENCE_NAME_LEADS_ = "leads_seq";
    public final static String SEQUENCE_NAME_TASK = "task_seq";

    public final static int ACTION_LOG_IN = 1; //登陆加分
    public final static int ACTION_ADD_MERCHANT = 10;//添加商户加分

    //正则表达式，验证手机号
    public final static String VALID_PATTERN_MOBILE = "1(3|4|5|7|8)\\d{9}";
    //参数组名
    public final static String PARAM_GROUP_LEADS_STATUS = "leads_status";
    public final static String PARAM_GROUP_TASK_PHASE = "task_phase";
    public final static String PARAM_GROUP_TASK_STATUS = "task_status";
    public final static String PARAM_GROUP_TASK_REGION = "region";
    public final static String PARAM_GROUP_BUSINESS_TYPE = "business_type";
    public final static String PARAM_GROUP_MERCHANT_INTENTION = "merchant_intention";
    public final static String PARAM_GROUP_TASK_TYPE = "task_type";
    public final static String PARAM_GROUP_CONTACT_POSITION = "contact_position";
    public final static String PARAM_GROUP_BRANCH = "branch";
    public final static String PARAM_GROUP_FEEDBACK_DAYS = "feedback_days";
    public final static String PARAM_GROUP_CREDIT_RATING = "credit_rating";
    public final static String PARAM_GROUP_PROVINCE = "province";
    public final static String PARAM_GROUP_USER_POINT_LEVEL = "user_point_level";
    public final static String PARAM_GROUP_CREDIT_LINE_DISPLAY_THRESHOLD = "credit_line_display_threshold";
    public final static String PARAM_GROUP_USER_TYPE = "user_type";
    public final static String PARAM_GROUP_PROCESSOR_ID = "processor_id";
    //入网天数状态
    public final static String PARAM_GROUP_IN_NET_DAYS_STATE = "in_net_days_state";
    //月刷卡额状态
    public final static String PARAM_GROUP_MONEY_PER_MONTH_STATE = "money_per_month_state";
    //上月交易状态
    public final static String PARAM_GROUP_LAST_MONTH_STATE = "last_month_state";
    public final static String PARAM_GROUP_REFUND_WAY = "refund_way";
    //逢9奖相关设置
    public final static String PARAM_GROUP_NINE_SUFFIX_PRIZE = "nine_suffix_prize";
    //商户行业大类
    public final static String PARAM_GROUP_MERCHANT_INDUSTRY = "merchant_industry";
    //营业面积
    public final static String PARAM_GROUP_BUSINESS_AREA = "business_area";
    //营业地段
    public final static String PARAM_GROUP_BUSINESS_LOCATION = "business_location";
    //员工数量
    public final static String PARAM_GROUP_STAFF_NUMBER = "staff_number";
    //教育情况
    public final static String PARAM_GROUP_EDUCATION_LEVEL = "education_level";
    //婚姻状况
    public final static String PARAM_GROUP_MARRIAGE_STATUS = "marriage_status";
    //子女状况
    public final static String PARAM_GROUP_CHILDREN_STATUS = "children_status";
    //户口情况
    public final static String PARAM_GROUP_HUKOU_STATUS = "hukou_status";

    //任务紧急程度
    public final static int TASK_URGENT_DEGREE_NORMAL = 1;

    //用户操作类型，用于记录操作日志
    public final static int ACTION_SHARE = 2;
    public final static int ACTION_TODO = 3;

    public final static int ACTION_CALCULATE = 5;
    public final static int ACTION_ADD_SALES = 6;
    public final static int ACTION_SCAN_QRCODE = 7;
    public final static int ACTION_SUBSCRIBE_QRCODE = 8;


    public final static int MOBILE_SEND = 115;//发送短信
    public final static int MOBILE_SEND_WEIXIN = 116;//发送微信
    //用户类型
    //公司内部员工
    public final static int USER_TYPE_STAFF = 0;
    //银商客户经理
    public final static int USER_TYPE_UMS_SALES = 1;
    //运营专员
    public final static int USER_TYPE_AGENT = 2;
    //测试号
    public final static int USER_TYPE_TESTING = 3;
    //商户
    public final static int USER_TYPE_MERCHANT = 4;
    //商户-转介绍标示-临时用
    public final static int USER_TYPE_MERCHANT_REFER = 40;
    //调用webservice
    public final static int USER_TYPE_INVOKER = 5;
    //通联客户经理
    public final static int USER_TYPE_ALLINPAY_SALES = 6;
    //杉德客户经理
    public final static int USER_TYPE_SANDPAY_SALES = 7;
    //银盛客户经理
    public final static int USER_TYPE_YS_SALES = 8;
    //民生银行客户经理 - 权限控制
    public final static int USER_TYPE_MS_SALES = 9;



    //现金券增加类型
    public final static int ACTION_CASH_COUPON_INVITE = 122;//银商客经邀请码添加商户日志类型

    public final static int ACTION_SUBSCRIBE_QRCODE_DISTRIBUTOR = 14;//分销商扫描
    public final static int ACTION_SYN_USER = 15;//用户微信注册调用网站同步用户数据
    public final static int ACTION_SYN_MERCHANT = 16;//用户微信认证调用网站同步商户MID数据
    public final static int ACTION_ADD_COUPON = 40;//调用Restful接口错误日志分类
    public final static int ACTION_RESTFUL = 50;//调用Restful接口错误日志分类
    public final static int ACTION_EXCAVATE_FAIL = 60;//调用Restful接口挖金铲错误日志分类
    public final static int ACTION_EXCAVATE_SUCCESS = 61;//调用Restful接口挖金铲成功日志分类
    public final static int ACTION_USER_EXCAVATE_SUCCESS = 62;//用户开始挖金铲记录成功日志
    public final static int ACTION_NEW_MERCHANT = 100;//新版商户微信错误标志
    public final static int ACTION_NEW_MANAGER = 1000;//微信登录错误标识
    public final static int ACTION_GET_MANAGER = 1001;//微信获取商户信息错误标识
    public final static int ACTION_UPDATE_MANAGER = 1001;//微信修改客经信息错误标识
    public final static int ACTION_CREATE_LEADS_FAILED = 1002;//创建线索失败
    public final static int ACTION_NEW_MERCHANT_BIND = 101;
    public final static int ACTION_NEW_MERCHANT_ADD_SHOP = 102;
    public final static int ACTION_NEW_MERCHANT_UPGRADE_LIMIT = 103;
    public final static int ACTION_NEW_MERCHANT_ADD_FILE = 104;
    public final static int ACTION_NEW_MERCHANT_UPDATE_PASSWORD = 105;


    //待确定
    public final static String PROCESSOR_ID_NA = "330";

    //特别区域，用于标识客勤可以查询所有区域
    public final static String CODE_ALL = "all";

    //默认遮掩码
    public final static String DEFAULT_MASK_STAR = "*";

    public final static String CREATOR_NAME_ME = "我";

    public final static String WE_PARAM_NAME_GRANT_TYPE = "grant_type";
    public final static String WE_PARAM_NAME_APPID = "appid";
    public final static String WE_PARAM_NAME_SECRET = "secret";
    public final static String WE_PARAM_NAME_ACCESS_TOKEN = "access_token";
    public final static String WE_PARAM_NAME_TICKET = "ticket";
    public final static String WE_PARAM_NAME_TYPE = "type";

    public final static String WE_PARAM_VALUE_GRANT_TYPE = "client_credential";

    public final static String WE_RESPONSE_KEY_ACCESS_TOKEN = "access_token";
    public final static String WE_RESPONSE_KEY_EXPIRES_IN  = "expires_in";

    public final static String WE_MESSAGE_TYPE_TEXT = "text";
    public final static String WE_MESSAGE_TYPE_EVENT = "event";
    public final static String WE_MESSAGE_TYPE_NEWS = "news";
    public final static String WE_MESSAGE_TYPE_FUNCTION = "function";
    public final static String WE_MESSAGE_TYPE_IMAGE = "image";

    public final static String WE_EVENT_TYPE_SUBSCRIBE = "subscribe";
    public final static String WE_EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public final static String WE_EVENT_TYPE_SCAN = "scan";
    public final static String WE_EVENT_TYPE_CLICK = "click";
    public final static String WE_EVENT_TYPE_LOCATION = "location";

    public final static String WE_MENU_BUTTON_TYPE_CLICK = "click";
    public final static String WE_MENU_BUTTON_TYPE_VIEW = "view";

    public final static String WE_SCAN_KEY_PREFIX = "qrscene_";

    public final static String RESULT_CODE_SUCCESS = "success";
    public final static String RESULT_CODE_FAILED = "failed";

    public final static String RESTFUL_RESULT_SUCCESS = "1";
    public final static String RESTFUL_RESULT_FAILED = "-1";

    public final static String RANDOM_CHAR_SET = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public final static int CHANNEL_SALES = 1;
    public final static int CHANNEL_MERCHANT = 2;

    public final static String QRCODE_PREFIX_LINK = "2";

    public final static String QRCODE_PREFIX_LINK_DISTRIBUTOR = "3";//分销商类型

    public final static String QRCODE_PREFIX_LINK_INSTANT_CREDIT = "21";//速融扫描二维码

    public final static char NINE_SUFFIX = '9';

    //申请流程结束
    public final static String APPLY_PROCESS_END = "1";
    //申请流程未结束
    public final static String APPLY_PROCESS_NOT_END = "0";

    //微信消息类型为文字消息text
    public final static String WECHAT_MESSAGE_TYPE_TEXT = "text";
    //微信消息类型为图片消息image
    public final static String WECHAT_MESSAGE_TYPE_IMAGE = "image";
    //申请流程失效时间,以分钟为单位
    public final static int APPLY_PROCESS_TIMEOUT = 15;
    //申请流程失效时间多少分以前，给用户推送提醒消息 （值为负数，如：-5表示在失效5分钟以前给出提醒）
    public final static int APPLY_PROCESS_BEFOR_TIMEOUT = -5;

    //速融超时时间(分钟单位)
    public final static int INSTANT_CREDIT_TIMEOUT = 10;//速融授信等待时间

    //后台列表分页大小
    public final  static Integer PAGE_SIZE = 10;

    public final  static Integer VERIFY_QUESTION_COUNT = 3;//验证身份问题数量
    public final  static Integer VERIFY_QUESTION_ANSWER_COUNT = 8; //验证身份每个问题答案数量


    public final  static String CLAUSE_TYPE_REGISTER = "1"; //同意注册条款；
    public final  static String CLAUSE_TYPE_ACCREDIT = "2"; //同意授权条款；
    public final  static String CLAUSE_TYPE_APPLY = "3"; //同意申请条款；
    public final  static String CLAUSE_TYPE_AFFIRM= "4"; //同意确认条款
    public final  static String CLAUSE_TYPE_ALL= "5"; //同意确认条款
    public final  static String BIND_BANK_CARD= "6"; //同意绑定银行卡


    public final  static String HTTP_METHOD_PUT= "PUT"; //RESTFUL-PUT方法
    public final  static String HTTP_METHOD_DELETE= "DELETE";//RESTFUL-DELETE方法

    public final  static String SESSION_KEY_NEW_MERCHANT_APPLICATION= "login_new_merchant_newest_application";//当前登录商户最新一条申请标志


}