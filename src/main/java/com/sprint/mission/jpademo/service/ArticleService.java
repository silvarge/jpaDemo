package com.sprint.mission.jpademo.service;

import com.sprint.mission.jpademo.dto.ArticleDto;
import com.sprint.mission.jpademo.model.Article;
import com.sprint.mission.jpademo.model.User;
import com.sprint.mission.jpademo.repository.ArticleRepository;
import com.sprint.mission.jpademo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public void createArticle(ArticleDto articleDto) {
        User user = userRepository.findById(articleDto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("해당 사용자는 존재하지 않습니다."));
        articleRepository.save(new Article(articleDto, user));
    }


    @Transactional
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);
    }

    public Article findArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(
                () -> {throw new IllegalArgumentException("해당 사용자는 존재하지 않습니다.");
                });
    }

    public List<Article> findArticlesByUserId(Long userId) {
        return articleRepository.findAllByUserId(userId);
    }

    public Article findUserArticleById(Long userId, Long id) {
        return articleRepository.findArticleByUserIdAndId(userId, id);
    }

    public void createUserArticleById(ArticleDto articleDto, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 존재하지 않습니다."));
        articleRepository.save(new Article(articleDto, user));
    }

    public void deleteUserArticleById(Long userId, Long articleId) {
        articleRepository.deleteArticleByUser_IdAndId(userId, articleId);
    }

}
