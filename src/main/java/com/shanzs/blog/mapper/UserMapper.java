package com.shanzs.blog.mapper;

import com.shanzs.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
  User getUser(User user);
}
