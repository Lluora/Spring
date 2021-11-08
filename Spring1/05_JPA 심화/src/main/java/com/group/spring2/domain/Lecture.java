package com.group.spring2.domain;

import javax.persistence.*;

@Entity // 테이블임을 나타냅니다.
public class Lecture extends Timestamped{

    public Lecture() {}

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTutor() {
        return this.tutor;
    }

    public Lecture(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }


    public void update(Lecture lecture) {
        this.title = lecture.title;
        this.tutor = lecture.tutor;
    }
}