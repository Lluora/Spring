package com.group.spring2;

import com.group.spring2.domain.Lecture;
import com.group.spring2.domain.LectureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring2Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring2Application.class, args);
    }
    // item01Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
    public CommandLineRunner demo(LectureRepository lectureRepository) {
        return (args) -> {
            Lecture course = new Lecture("웹개발의 봄", "남병관");
            lectureRepository.save(course);
            lectureRepository.findAll();
        };
    }
}
