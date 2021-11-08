package com.group.spring2.prac;

public class Course {
    public String title;
    public String tutor;
    public int days;

    // 이렇게 아무런 파라미터가 없는 생성자를 기본생성자 라고 부릅니다.
    public Course() {
    }

    // Getter
    public String getTitle() {
        return this.title;
    }
    // Getter
    public String getTutor() {
        return this.tutor;
    }
    // Getter
    public int getDays() {
        return this.days;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }
    // Setter
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    // Setter
    public void setDays(int days) {
        this.days = days;
    }
}
