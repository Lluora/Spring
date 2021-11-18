package com.sparta.week02.controller;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor //초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
@RestController // json으로 응답
public class CourseController {

    private final CourseRepository courseRepository;

    private final CourseService courseService;

    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/courses") // 생성 _post
    public Course createCourse(@RequestBody CourseRequestDto requestDto) {
        // RequestBody : controller에서 요청을 받는 녀석이다라는 것을 표시
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return courseRepository.save(course);
    }


    @GetMapping("/api/courses") //Get 방식_조회요청
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }


    // PUT
    @PutMapping("/api/courses/{id}") //@PathVariable이 있어서 {id}가 2면 Long 2가 된다.
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.update(id, requestDto);
    }


    // Delete
    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }
}