package com.group.spring2.controller;

import com.group.spring2.domain.Lecture;
import com.group.spring2.domain.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LectureController {

    private final LectureRepository lectureRepository;

    @GetMapping("/api/lectures")
    public List<Lecture> getLectures() {
        return lectureRepository.findAll();
    }
}
