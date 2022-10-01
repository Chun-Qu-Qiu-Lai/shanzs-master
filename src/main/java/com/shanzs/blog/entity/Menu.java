package com.shanzs.blog.entity;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable {
  private Integer id;
  private String name;
  private int pid;
  private int visible;
  private String path;
  private Date create_time;

  public Menu() {
  }

  public Menu(Integer id, String name, int pid, int visible, String path, Date create_time) {
    this.id = id;
    this.name = name;
    this.pid = pid;
    this.visible = visible;
    this.path = path;
    this.create_time = create_time;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }

  public int getVisible() {
    return visible;
  }

  public void setVisible(int visible) {
    this.visible = visible;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Date getCreate_time() {
    return create_time;
  }

  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }
}
