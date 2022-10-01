package com.shanzs.blog.controller;

import cn.hutool.core.util.StrUtil;
import com.shanzs.blog.entity.Result;
import com.shanzs.blog.entity.ResultStatus;
import com.shanzs.blog.entity.User;
import com.shanzs.blog.mapper.UserMapper;
import com.shanzs.blog.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/shanzs/blog")
public class LoginController {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/login")
  private Result login(@RequestBody User userForm) {
    if (StrUtil.isBlank(userForm.getUsername())) {
      return Result.fail(ResultStatus.HTTP_STATUS_410);
    }
    if (StrUtil.isBlank(userForm.getPassword())) {
      return Result.fail(ResultStatus.HTTP_STATUS_409);
    }
    User user = userMapper.getUser(userForm);
    Integer id;
    try {
      id = user.getId();
    } catch (Exception e) {
      return Result.fail(ResultStatus.HTTP_STATUS_411);
    }
    String token = JwtUtil.createToken(String.valueOf(id));
    Map<String, Object> map = new HashMap<>();
    map.put("token", token);
    return Result.success(ResultStatus.SUCCESS, map);
  }
}


