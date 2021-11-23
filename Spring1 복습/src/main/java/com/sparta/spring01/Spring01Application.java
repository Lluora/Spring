package com.sparta.spring01;

import com.sparta.spring01.domain.Lecture;
import com.sparta.spring01.domain.LectureRepository;
import com.sparta.spring01.dto.LectureRequestDto;
import com.sparta.spring01.service.LectureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing //시간에 대해서 자동으로 값을 넣어주는 기능
@SpringBootApplication
public class Spring01Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring01Application.class, args);
    }

    // jpa 실행 코드
    @Bean
    public CommandLineRunner demo(LectureRepository lectureRepository, LectureService lectureService) {
        return (args) -> {
//            Lecture course = new Lecture("봄봄", "호호");
//            lectureRepository.save(course);
//            lectureRepository.findAll();

            lectureRepository.save(new Lecture("꽃", "에?"));
            List<Lecture> lectureList = lectureRepository.findAll();
            for (int i=0; i<lectureList.size(); i++) {
                Lecture lecture = lectureList.get(i);
                System.out.println(lecture.getId());
                System.out.println(lecture.getTitle());
                System.out.println(lecture.getTutor());
            }

            LectureRequestDto requestDto = new LectureRequestDto("new flower", "beeee");
            lectureService.update(1L, requestDto);
            lectureList = lectureRepository.findAll();
            for (int i=0; i<lectureList.size(); i++) {
                Lecture lecture = lectureList.get(i);
                System.out.println(lecture.getId());
                System.out.println(lecture.getTitle());
                System.out.println(lecture.getTutor());

            }

//            Lecture lecture = lectureRepository.findById(1L).orElseThrow(
//                    () -> new IllegalArgumentException("아이디가 읎다.")
//            );
        };
    }

}
