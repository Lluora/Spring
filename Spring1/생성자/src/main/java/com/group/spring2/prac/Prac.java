package com.group.spring2.prac;

public class Prac {
    public static void main(String[] args) {

        Course course = new Course();
        System.out.println(course.title);
        System.out.println(course.tutor);
        System.out.println(course.days);

        Course course2 = new Course("웹개발의 봄 스프링", "냠냠", 35);
        System.out.println(course2.title);
        System.out.println(course2.tutor);
        System.out.println(course2.days);
    }
}
