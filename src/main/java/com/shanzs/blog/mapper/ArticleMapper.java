package com.shanzs.blog.mapper;

import com.shanzs.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
  int insertArticle(Article article);

  List<Article> getArticlesByCategory(String category);
  List<Article> listArticle();
  Article getArticleById(int articleId);
}
