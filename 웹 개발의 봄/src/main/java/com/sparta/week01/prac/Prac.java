package com.sparta.week01.prac;

public class Prac {

    public static void main(String[] args) {
        String title = "웹개발의 봄, Spring";
        String tutor = "haha";
        int days = 35;

        //setter
        Course course = new Course();
        course.setTitle(title);
        course.setTutor(tutor);
        course.setDays(days);

        //getter
        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
    }
}