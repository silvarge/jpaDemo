package com.sprint.mission.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

}

// HandlerAdapter
// XML기반, file 기반의 경우 커스텀으로 HandlerAdapter를 만들어서 사용한다!