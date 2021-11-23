package com.sparta.spring01.prac;

public class Prac {
    public String name;



    public static void main(String[] args) {
//        Prac prac = new Prac();
//        prac.name = "haha";

        Course course = new Course();

        course.setTitle("네?");
        course.setTutor("왜요?");
        course.setDays(22);
        Tutor tutor = new Tutor();
        tutor.setName("ha");
        tutor.setBio(2);
        System.out.println(tutor.getName());
        System.out.println(tutor.getBio());

        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
        System.out.println(course.getDays());



    }
}
