package com.shanzs.blog.entity;


import java.io.Serializable;

/**
 * @author 72431
 */
public class Result<T> implements Serializable {

  private int code;
  private String msg;
  private T data;


  public static <T> Result<T> success() {
    return success(null);
  }

  public static <T> Result<T> success(T data) {
    return new Result<T>(ResultStatus.SUCCESS.getResultCode(), ResultStatus.SUCCESS.getResultDescription(), data);
  }

  public static <T extends Serializable> Result<T> fail() {
    return fail(null);
  }

  public static <T> Result<T> fail(T data) {
    return new Result<T>(ResultStatus.FAIL.getResultCode(), ResultStatus.FAIL.getResultDescription(), data);
  }

  public Result(int code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
