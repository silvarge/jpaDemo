package com.sprint.mission.jpademo.dto;

import com.sprint.mission.jpademo.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ArticleDto {
    private String title;
    private String content;
    private Long userId;
}
