package com.shanzs.blog.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ResultStatus {

  SUCCESS(200, "success"),
  FAIL(500, "failed"),

  HTTP_STATUS_200(200, "ok"),
  HTTP_STATUS_400(400, "request error"),
  HTTP_STATUS_401(401, "no authentication"),
  HTTP_STATUS_403(403, "no authorities"),
  HTTP_STATUS_409(409,"密码为空"),
  HTTP_STATUS_408(411,"账号为空"),
  HTTP_STATUS_411(409,"查无此人"),
  HTTP_STATUS_410(410, "server error");




  public static final List<ResultStatus> HTTP_STATUS_ALL = Collections.unmodifiableList(
          Arrays.asList(HTTP_STATUS_200,
                  HTTP_STATUS_400,
                  HTTP_STATUS_401,
                  HTTP_STATUS_403,
                  HTTP_STATUS_409,
                  HTTP_STATUS_410,
                  HTTP_STATUS_408
          ));

  /**
   * response code
   */
  private final int resultCode;

  /**
   * description.
   */
  private final String resultDescription;

  ResultStatus(int resultCode, String resultDescription) {
    this.resultCode = resultCode;
    this.resultDescription = resultDescription;
  }

  public int getResultCode() {
    return resultCode;
  }

  public String getResultDescription() {
    return resultDescription;
  }
}

