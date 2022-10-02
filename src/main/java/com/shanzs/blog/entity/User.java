package com.shanzs.blog.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
  private Integer id;
  private String username;
  private String password;

  private Date create_time;
  private Date update_time;

  public User() {

  }

  public User(Integer id, String username, String password, Date create_time, Date update_time) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.create_time = create_time;
    this.update_time = update_time;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }

  public Date getUpdate_time() {
    return update_time;
  }

  public void setUpdate_time(Date update_time) {
    this.update_time = update_time;
  }
}
