package com.sparta.polo.Service;

import com.sparta.polo.domain.Member;
import com.sparta.polo.domain.MemberRepository;
import com.sparta.polo.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;



    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Member createMember(MemberRequestDto requestDto)  {
        Member member = new Member(requestDto);
        memberRepository.save(member);
        return member;
    }



    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, MemberRequestDto requestDto) {
        Member member1 = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디 읎다아아")
        );
        member1.update(requestDto);
        return member1.getId();
    }
}
