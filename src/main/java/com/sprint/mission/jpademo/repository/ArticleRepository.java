package com.sprint.mission.jpademo.repository;

import com.sprint.mission.jpademo.model.Article;
import com.sprint.mission.jpademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByUserId(Long userId);

    Article findArticleByUserIdAndId(Long userId, Long id);

    void deleteArticleByUser_IdAndId(Long userId, Long id);
}
