package com.shanzs.blog.mapper;

import com.shanzs.blog.entity.Poem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PoemMapper {
  Poem getPoemByRandom();
}
