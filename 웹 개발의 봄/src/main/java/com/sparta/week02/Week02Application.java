package com.sparta.week02;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
// Entity에 있어서 기본적으로 포함되는 createdAt, modifiedAt, createdBy, modifiedBy등을 자동으로 주입시킬 수있도록 해주는 설정

@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }
//
//    // Week02Application.java 의 main 함수 아래에 붙여주세요.
//    @Bean
//    public CommandLineRunner demo(CourseRepository repository) {
//        return (args) -> {
//
//            // 데이터 저장하기
//            repository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));
//
//           // 데이터 전부 조회하기
//            List<Course> courseList = repository.findAll();
//            for (int i = 0; i < courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//
//             // 데이터 하나 조회하기
//            Course course = repository.findById(1L).orElseThrow( //오류내보기 1L 대신 2L)
//                    () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
//                    //IllegalArgumentException 과 NullPointerException 차이?
//                    // NullPointerException: 가리키는게 없을 때 (null을 가리키면)


//    // update 실행하기
//    @Bean
//    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
//        return (args) -> {
//            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));
//
//            System.out.println("데이터 인쇄");
//            List<Course> courseList = courseRepository.findAll();
//            for (int i = 0; i < courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//
//            Course new_course = new Course("웹개발의 봄, Spring", "임민영");
//            courseService.update(1L, new_course);
//            courseList = courseRepository.findAll();
//            for (int i = 0; i < courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//        };
//    }


    // delete
    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            Course new_course = new Course("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, new_course);
            courseList = courseRepository.findAll();
            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            courseRepository.deleteAll();
        };
    }


};

