package com.sparta.spring01.service;

import com.sparta.spring01.domain.Lecture;
import com.sparta.spring01.domain.LectureRepository;
import com.sparta.spring01.dto.LectureRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LectureService {
    private final LectureRepository lectureRepository;
//@RequiredArgsConstructor대신 아래 코드 작성
//    public LectureService(LectureRepository lectureRepository) {
//        this.lectureRepository = lectureRepository;
//    }


    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, LectureRequestDto requestDto) {
        Lecture lecture1 = lectureRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디 읎다아아")
        );
        lecture1.update(requestDto);
        return lecture1.getId();
   }
}
