package com.shanzs.blog.service.impl;

import com.shanzs.blog.Exception.ServiceException;
import com.shanzs.blog.entity.User;
import com.shanzs.blog.entity.UserDetail;
import com.shanzs.blog.mapper.UserMapper;
import com.shanzs.blog.security.context.AuthenticationContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userMapper.selectUserByUsername(username);
    if (user == null) {
      System.out.println("用户：" + username + "不存在");
      throw new ServiceException("用户：" + username + "不存在");
    }
    Authentication usernamePasswordAuthenticationToken = AuthenticationContextHolder.getContext();
    String formPassword = usernamePasswordAuthenticationToken.getCredentials().toString();
    System.out.println(formPassword);
    System.out.println(user.getPassword());
    System.out.println(bCryptPasswordEncoder.matches(formPassword, user.getPassword()));
    if (!bCryptPasswordEncoder.matches(formPassword, user.getPassword())) {
      System.out.println("用户：" + username + "密码验证失败");
      throw new ServiceException("用户：" + username + "密码验证失败");
    }
    System.out.println("通过");
    return createLoginUser(user);
  }

  public UserDetails createLoginUser(User user) {
    return new UserDetail(user.getId(), user.getUsername(), user.getPassword());
  }
}
