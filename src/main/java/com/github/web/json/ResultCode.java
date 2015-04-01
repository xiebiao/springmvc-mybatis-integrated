package com.github.web.json;

/**
 * @author xiebiao
 * @date 3/1/15
 */
public enum ResultCode {

    SUCCESS(0, "SUCCESS", "成功"),
    FAILED(1, "FAILED", "失败"),
    NO_DATA(2, "NO DATA", "没有数据"),
    ILLEGAL_REQUEST(3, "ILLEGAL REQUEST", "非法请求"),
    SESSION_EXPIRED(4, "SESSION EXPIRED", "登录超时"),
    REQUEST_ERROR(5, "REQUEST ERROR", "请求错误，参数不正确"),
    ERROR_SMS_IDENTF_CODE(100, "ERROR SMS IDENTIFYING CODE", "短信验证码错误"),
    LOGIN_FAILED(101, "LOGIN FAILED", "登录失败"),
    UNKNOWN_LOGIN_FROM(102, "UNKOWN LOGIN FROM", "未知登录来源"),
    MOBILE_IS_EXIST(103, "MOBILE IS EXIST", "手机号已存在"),
    REGISTER_FAILED(104, "REGISTER FAILED", "注册失败"),
    VOTE_FAILED(105, "VOTE FAILED", "投票失败，不能重复投票"),
    SEND_MESSAGE_FAILED(106, "SEND MESSAGE FAILED", "短信验证码60秒内不能重复发送"),
    ACCOUNT_OR_PASSWORD_ERROR(107, "ACCOUNT OR PASSWORD ERROR", "帐号或密码错误"),
    ACCESS_UPYUN_FAILED(2000, "ACCESS UPYUN FAILED", "访问又拍云失败"),
    SERVER_EXCEPTION(9000, "SERVER EXCEPTION", "服务器有点累了，稍后再试试");

    private int code;
    private String desc;
    private String msg;

    ResultCode(int code, String desc, String msg) {
        this.code = code;
        this.desc = desc;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
