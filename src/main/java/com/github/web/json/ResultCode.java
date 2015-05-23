package com.github.web.json;

/**
 * @author xiebiao
 * @date 3/1/15
 */
public enum ResultCode {

  SUCCESS(0, "SUCCESS", "成功"), FAILED(1, "FAILED", "失败"), NO_DATA(2, "NO DATA", "没有数据"), SERVER_EXCEPTION(
      9000, "SERVER EXCEPTION", "服务器有点累了，稍后再试试");

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
