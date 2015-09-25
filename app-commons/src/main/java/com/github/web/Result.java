package com.github.web;

/**
 * @author xiebiao
 * @date 3/1/15
 */
public class Result<T> {

  private T data;
  private int code;
  private String desc;
  private String msg;

  public Result() {
    this.code = ResultCode.SUCCESS.getCode();
    this.msg = ResultCode.SUCCESS.getMsg();
    this.desc = ResultCode.SUCCESS.getDesc();
  }

  public Result(ResultCode resultCode) {
    this.code = resultCode.getCode();
    this.desc = resultCode.getDesc();
    this.msg = resultCode.getMsg();
  }

  public void setResultCode(ResultCode resultCode) {
    this.code = resultCode.getCode();
    this.desc = resultCode.getDesc();
    this.msg = resultCode.getMsg();
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
    this.setResultCode(ResultCode.SUCCESS);
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
