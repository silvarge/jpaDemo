package com.sprint.mission.jpademo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    /**
     * shutdown life cycle이 2초인 설정에서
     * 30초간 Sleep하는 동안 정상 종료(kill -15) 요청이 발생할 경우, 작업 실패 로그가 어떻게 나오는지 확인
     */
    @GetMapping("/test")
    public void test() throws InterruptedException {

        log.warn("Start");

        // 30초간 sleep
        Thread.sleep(5000);

        log.warn("finish");
    }
}
