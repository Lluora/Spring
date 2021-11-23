package com.sparta.spring01.controller;

import com.sparta.spring01.domain.Lecture;
import com.sparta.spring01.domain.LectureRepository;
import com.sparta.spring01.dto.LectureRequestDto;
import com.sparta.spring01.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LectureController {
    private final LectureRepository lectureRepository;
    private final LectureService lectureService; // Put은 Service단에서 갖고오므로

    @GetMapping("/api/lectures")
    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }

    @PostMapping("/api/lectures")
    public Lecture createLecture(@RequestBody LectureRequestDto requestDto) {
        // requestDto 는, 생성 요청

        Lecture lecture = new Lecture(requestDto);
        // 저장하는 것은 Dto가 아니라 Lecture이니, Dto의 정보를 lecture에 담아야 합니다.
        return lectureRepository.save(lecture);
    }

    @PutMapping("/api/lectures/{id}")
    public Long updateLecture(@PathVariable Long id, @RequestBody LectureRequestDto requestDto) {
        return lectureService.update(id, requestDto);
    }
}
