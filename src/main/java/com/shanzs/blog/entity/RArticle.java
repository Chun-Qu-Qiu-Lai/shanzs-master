package com.shanzs.blog.entity;


import java.io.Serializable;
import java.util.Date;


public class RArticle implements Serializable {
  private Integer id;
  private String title;
  private String content;
  private String category;

  public RArticle() {
  }

  public RArticle(Integer id, String title, String content, String category) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.category = category;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
