package com.shanzs.blog.entity;

import java.util.Date;


public class Article {
  private Integer id;
  private String author;
  private String title;
  private byte[] content;
  private String category;
  private Date create_time;
  private Date update_time;

  public Article() {
  }

  ;

  public Article(Integer id, String author, String title, byte[] content, String category, Date create_time, Date update_time) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.content = content;
    this.category = category;
    this.create_time = create_time;
    this.update_time = update_time;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
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
