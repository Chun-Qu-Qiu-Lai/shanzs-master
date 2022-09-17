package com.shanzs.blog.entity;


import java.io.Serializable;

/**
 * @author 72431
 */
public class Result<T> implements Serializable {

  private int code;
  private String msg;
  private T data;

  public Result(int code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }
  public Result(int code, String msg) {
    this.code = code;
    this.msg = msg;
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
