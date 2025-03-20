package com.sprint.mission.jpademo.controller;

import com.sprint.mission.jpademo.dto.ArticleDto;
import com.sprint.mission.jpademo.model.Article;
import com.sprint.mission.jpademo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/articles")
@RequiredArgsConstructor
public class UserArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> getArticleListByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(articleService.findArticlesByUserId(userId));
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<Article> getArticleByUserId(@PathVariable Long userId, @PathVariable("articleId") Long articleId) {
        return ResponseEntity.ok(articleService.findUserArticleById(userId, articleId));
    }

    @PostMapping
    public ResponseEntity<String> createArticleByUserId(@PathVariable Long userId, @RequestBody ArticleDto articleDto) {
        articleService.createUserArticleById(articleDto, userId);
        return ResponseEntity.ok("해당 사용자의 게시글이 등록되었습니다.");
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<String> deleteArticleByUserId(@PathVariable Long userId, @PathVariable("articleId") Long articleId) {
        articleService.deleteUserArticleById(userId, articleId);
        return ResponseEntity.ok("해당 사용자의 게시글이 삭제되었습니다.");
    }
}
