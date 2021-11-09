package com.group.spring2.prac;

public class Prac {
    public static void main(String[] args) {
        Course course = new Course();
        Tutor tutor = new Tutor();

        course.setTitle("웹개발의 봄 스프링");
        course.setTutor("남병관");
        course.setDays(35);

        tutor.setName("호호");
        tutor.setBio("7");

        System.out.println(course.getTitle());
        System.out.println(course.getTutor());
        System.out.println(course.getDays());

        System.out.println(tutor.getName());
        System.out.println(tutor.getBio());

    }
}
