package com.shanzs.blog.mapper;

import com.shanzs.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 72431
 */
@Mapper
public interface UserMapper {
  User selectUserByUsername(String username);
}
