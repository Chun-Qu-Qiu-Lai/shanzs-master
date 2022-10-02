package com.shanzs.blog.controller;

import cn.hutool.core.util.StrUtil;
import com.shanzs.blog.Exception.ServiceException;
import com.shanzs.blog.entity.Result;
import com.shanzs.blog.entity.ResultStatus;
import com.shanzs.blog.entity.User;
import com.shanzs.blog.entity.UserDetail;
import com.shanzs.blog.security.context.AuthenticationContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/shanzs/blog")
public class LoginController {

  @Resource
  private AuthenticationManager authenticationManager;

  @PostMapping("/login")
  private Result login(@RequestBody User userForm) {
    if (StrUtil.isBlank(userForm.getUsername())) {
      return Result.fail(ResultStatus.HTTP_STATUS_410);
    }
    if (StrUtil.isBlank(userForm.getPassword())) {
      return Result.fail(ResultStatus.HTTP_STATUS_409);
    }
    Authentication authentication = null;
    try {
      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userForm.getUsername(), userForm.getPassword());
      AuthenticationContextHolder.setContext(authenticationToken);
      authentication = authenticationManager.authenticate(authenticationToken);
    } catch (Exception e) {
      System.out.println("验证用户失败" + e);
      throw new ServiceException("验证用户失败" + e);
    } finally {
      AuthenticationContextHolder.clearContext();
    }
    UserDetail user = (UserDetail) authentication.getPrincipal();

//    Integer id;
//    try {
//      id = user.getId();
//    } catch (Exception e) {
//      return Result.fail(ResultStatus.HTTP_STATUS_411);
//    }
//    String token = JwtUtil.createToken(String.valueOf(id));
//    Map<String, Object> map = new HashMap<>();
//    map.put("token", token);
//    return Result.success(ResultStatus.SUCCESS, map);
    return null;
  }
}


