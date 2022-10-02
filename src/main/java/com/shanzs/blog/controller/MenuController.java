package com.shanzs.blog.controller;

import com.shanzs.blog.entity.Result;
import com.shanzs.blog.entity.ResultStatus;
import com.shanzs.blog.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/shanzs/blog")
public class MenuController {
  @Autowired
  private MenuMapper menuMapper;

  @GetMapping("/get_menus")
  private Result listMenu() {
    return Result.success(ResultStatus.SUCCESS, menuMapper.selectMenuList());
  }

}
