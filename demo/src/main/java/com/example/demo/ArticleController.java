package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleService articleService;

  @PostMapping
  @ResponseBody
  public String article(@RequestBody ArticleBody article) {
    return articleService.createArticle(article.content()).toString();
  }

  private static record ArticleBody(String content) {

  }
}
