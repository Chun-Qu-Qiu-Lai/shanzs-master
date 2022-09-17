package com.shanzs.blog.controller;

import com.shanzs.blog.entity.Article;
import com.shanzs.blog.entity.Result;
import com.shanzs.blog.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 72431
 */
@CrossOrigin
@RestController
@RequestMapping("/shanzs/blog")
public class ArticleController {
  @Autowired
  private ArticleMapper articleMapper;

  @PostMapping("/create_article")
  private Result postController(@RequestParam("articleTitle") String articleTitle,
                                @RequestParam("articleCategory") String articleCategory,
                                @RequestParam("articleContent") String articleContent) {
    System.out.println(articleTitle);
    Article article = new Article();
    article.setTitle(articleTitle);
    article.setCategory(articleCategory);
    article.setContent(articleContent.getBytes());
    articleMapper.insertArticle(article);
    return new Result<>(200, "成功");
  }

  @GetMapping("/get_articles")
  private Result getArticles(@RequestParam(value = "category", required = false) String category) {
    System.out.println(category);
    List<Article> articles = new ArrayList<>();
    if (category == null) {
      articles = articleMapper.listArticle();
    } else {
      articles = articleMapper.getArticlesByCategory(category);
    }
    List<Object> resultArticles = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    for (Article article : articles) {
      Map<String, Object> ar = new LinkedHashMap<>();
      String convert = new String(article.getContent(), StandardCharsets.UTF_8);
      ar.put("id", article.getId());
      ar.put("author", article.getAuthor());
      ar.put("title", article.getTitle());
      ar.put("content", convert);
      //
      List<String> contentList = new ArrayList<>();
      String[] strs = convert.split("\n");
      for (int i = 0, len = strs.length; i < len; i++) {
        contentList.add(strs[i].toString());
      }
      ar.put("contentList", contentList);
//      int count = 0;
//      String s = "\n";
//      while (convert.indexOf(s) != -1) {
//        convert = convert.substring(convert.indexOf(s) + 1, convert.length());
//        count++;
//      }
      //
      ar.put("category", article.getCategory());
      ar.put("create_time", sdf.format(article.getCreate_time()));
      ar.put("update_time", article.getUpdate_time());
      resultArticles.add(ar);
    }
    return new Result<>(200, "成功", resultArticles);
  }

  @GetMapping("/get_article")
  private Result getArticlesByCategory(@RequestParam("articleId") String articleId) {
    List<Article> articles = articleMapper.getArticlesByCategory(articleId);
    List<Object> resultArticles = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    for (Article article : articles) {
      Map<String, Object> ar = new LinkedHashMap<>();
      String convert = new String(article.getContent(), StandardCharsets.UTF_8);
      ar.put("id", article.getId());
      ar.put("author", article.getAuthor());
      ar.put("title", article.getTitle());
      ar.put("content", convert);
      List<String> contentList = new ArrayList<>();
      String[] strs = convert.split("\n");
      for (int i = 0, len = strs.length; i < len; i++) {
        contentList.add(strs[i].toString());
      }
      ar.put("contentList", contentList);
      ar.put("category", article.getCategory());
      ar.put("create_time", sdf.format(article.getCreate_time()));
      ar.put("update_time", article.getUpdate_time());
      resultArticles.add(ar);
    }
    return new Result<>(200, "成功", resultArticles);
  }
}
