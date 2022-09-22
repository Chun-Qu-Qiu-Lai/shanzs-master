package com.shanzs.blog.entity;

import java.io.Serializable;
import java.util.Date;

public class Poem implements Serializable {
  private Integer id;
  private String title;
  private String author;
  private String poemOne;
  private String poemTwo;
  private Date create_time;
  private Date update_time;

  public Poem() {
  }

  public Poem(Integer id, String title, String author, String poemOne, String poemTwo, Date create_time, Date update_time) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.poemOne = poemOne;
    this.poemTwo = poemTwo;
    this.create_time = create_time;
    this.update_time = update_time;
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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPoem_one() {
    return poemOne;
  }

  public void setPoem_one(String poemOne) {
    this.poemOne = poemOne;
  }

  public String getPoem_two() {
    return poemTwo;
  }

  public void setPoem_two(String poemTwo) {
    this.poemTwo = poemTwo;
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
