package com.sparta.spring01.domain;

import com.sparta.spring01.dto.LectureRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Getter
@NoArgsConstructor
@Entity // 테이블임을 나타낸다.
public class Lecture extends Timestamped {

//    public Lecture() {
//    }

    public Lecture(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public Lecture (LectureRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String tutor;

//    public Long getId() {
//        return id;
//    }
//    public String getTitle() {
//        return this.title;
//    }
//    public String getTutor() {
//        return this.tutor;
//    }


    public void update(LectureRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

}
