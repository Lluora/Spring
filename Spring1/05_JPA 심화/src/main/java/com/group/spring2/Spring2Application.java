package com.group.spring2;

import com.group.spring2.domain.Lecture;
import com.group.spring2.domain.LectureRepository;
import com.group.spring2.service.LectureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Spring2Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring2Application.class, args);
    }



 /*   = = = create & read  해보기 = = = =
 @Bean
    public CommandLineRunner demo(LectureRepository lectureRepository) {
        return (args) -> {
            // 데이터 저장하기
            lectureRepository.save(new Lecture("프론트엔드의 꽃, 리액트", "임민영"));

// 데이터 전부 조회하기
            List<Lecture> lectureList = lectureRepository.findAll();
            for (int i = 0; i < lectureList.size(); i++) {
                Lecture lecture = lectureList.get(i);
                System.out.println(lecture.getId());
                System.out.println(lecture.getTitle());
                System.out.println(lecture.getTutor());
            }

// 데이터 하나 조회하기
            Lecture lecture = lectureRepository.findById(1L).orElseThrow(
                    () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
            );
        };
    }
    */




        //  update 실행해보기  //
    /*
    @Bean
    public CommandLineRunner demo(LectureRepository lectureRepository, LectureService lectureService) {
        return (args) -> {
            lectureRepository.save(new Lecture("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Lecture> lectureList = lectureRepository.findAll();
            for (int i = 0; i < lectureList.size(); i++) {
                Lecture lecture = lectureList.get(i);
                System.out.println(lecture.getId());
                System.out.println(lecture.getTitle());
                System.out.println(lecture.getTutor());
            }

            Lecture new_lecture = new Lecture("웹개발의 봄, Spring", "임민영");
            lectureService.update(1L, new_lecture);
            lectureList = lectureRepository.findAll();
            for (int i = 0 ; i < lectureList.size() ; i++) {
                Lecture lecture = lectureList.get(i);
                System.out.println(lecture.getId());
                System.out.println(lecture.getTitle());
                System.out.println(lecture.getTutor());
            }
        };
    }
*/




    // DELETE 해보기
    @Bean
    public CommandLineRunner demo(LectureRepository lectureRepository, LectureService lectureService) {
        return (args) -> {
            lectureRepository.save(new Lecture("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Lecture> lectureList = lectureRepository.findAll();
            for (int i = 0; i < lectureList.size(); i++) {
                Lecture lecture = lectureList.get(i);
                System.out.println(lecture.getId());
                System.out.println(lecture.getTitle());
                System.out.println(lecture.getTutor());
            }

            Lecture new_lecture = new Lecture("웹개발의 봄, Spring", "임민영");
            lectureService.update(1L, new_lecture);
            lectureList = lectureRepository.findAll();
            for (int i = 0 ; i < lectureList.size() ; i++) {
                Lecture lecture = lectureList.get(i);
                System.out.println(lecture.getId());
                System.out.println(lecture.getTitle());
                System.out.println(lecture.getTutor());
            }

            lectureRepository.deleteAll();
        };
    }



}
