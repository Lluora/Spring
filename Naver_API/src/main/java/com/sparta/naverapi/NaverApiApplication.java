package com.sparta.naverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing // 시간 자동 변경이 가능하도록 합니다.
//@ServletComponentScan  // 3 layer 설정 후 주석 처리
public class NaverApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaverApiApplication.class, args);
    }
}

