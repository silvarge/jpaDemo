package com.sprint.mission.jpademo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.requiresChannel(channel ->
        channel.anyRequest().requiresSecure() // HTTP 요청을 HTTPS로 강제 변환
    );
    return http.build();
  }
}