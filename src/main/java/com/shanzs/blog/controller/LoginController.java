package com.shanzs.blog.controller;

import com.shanzs.blog.entity.Result;
import com.shanzs.blog.entity.ResultStatus;
import com.shanzs.blog.entity.User;
import com.shanzs.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/shanzs/blog")
public class LoginController {
  @Autowired
  private UserMapper userMapper;

  @PostMapping("/login")
  private Result login(@RequestBody User user) {
    if (user.getUsername().isEmpty()) {
      return Result.fail(ResultStatus.HTTP_STATUS_411);
    }
    if (user.getPassword().isEmpty()) {
      return Result.fail(ResultStatus.HTTP_STATUS_409);
    }
    if (userMapper.getUser(user) == null) {
      return Result.fail(ResultStatus.HTTP_STATUS_411);
    }
    return Result.success();
  }
}


