package com.sparta.polo.domain;

import com.sparta.polo.dto.MemberRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity // 테이블임을 나타냅니다.
public class Member {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Member(MemberRequestDto requestDto) {
        //MemberRequestDto에서 @ Getter를 설정해줘야 getName, getAge에서 오류 안뜸
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
    }

    public void update(MemberRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
    }
}