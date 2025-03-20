package com.sprint.mission.jpademo.controller;

import com.sprint.mission.jpademo.dto.ArticleDto;
import com.sprint.mission.jpademo.model.Article;
import com.sprint.mission.jpademo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<Article> listArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id){
        return articleService.findArticleById(id);
    }

    @PostMapping
    public String createArticle(@ModelAttribute ArticleDto articleDto) {
        articleService.createArticle(articleDto);
        return "redirect:/articles";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
        return ResponseEntity.ok("Article deleted successfully");
    }
}
