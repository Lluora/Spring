package com.sparta.week02.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

// Course 요청 관련 정보를 물고 다닐 녀석 → CourseRequestDto
@Setter
@RequiredArgsConstructor
@Getter
public class CourseRequestDto { //Course가 2개 가지고 있으므로 멤버면수 2개
    private final String title;
    private final String tutor;
}
