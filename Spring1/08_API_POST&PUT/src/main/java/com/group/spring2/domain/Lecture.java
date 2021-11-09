package com.group.spring2.domain;

import com.group.spring2.dto.LectureRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor // 빈 생성자
@Entity // 테이블임을 나타냅니다.
public class Lecture extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

    /*
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getTutor() {
        return this.tutor;
    }
    */


    ////////// 아래 requestDto와 다른 타입임 //////////
    public Lecture(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }


    // POST
    public Lecture(LectureRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }


    public void update(LectureRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}