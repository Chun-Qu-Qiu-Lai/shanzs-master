package com.shanzs.blog.mapper;

import com.shanzs.blog.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
  List<Menu> listMenu();
}
