package com.shanzs.blog.mapper;

import com.shanzs.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
  //插入文章
  int insertArticle(Article article);

  //获取所有文章
  List<Article> listArticle();

  //获取文章通过分类
  List<Article> getArticlesByCategory(String category);

  //获取文章通过文章id
  Article getArticleById(int id);

  //修改文章
  int updateArticle(Article article);

  int deleteArticle(int articleId);
}
