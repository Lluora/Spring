package com.sparta.polo.Controller;

import com.sparta.polo.Service.MemberService;
import com.sparta.polo.domain.Member;
import com.sparta.polo.domain.MemberRepository;
import com.sparta.polo.dto.MemberRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController//단순히 객체만을 반환하고 객체 데이터는 JSON 또는 XML 형식으로 HTTP 응답에 담아서 전송
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService; // // Put은 Service단에서 갖고오므로


    // @RequiredArgsConstructor 이걸로 써도 됨
    @Autowired
    public MemberController(MemberRepository memberRepository, MemberService memberService) {
        this.memberRepository = memberRepository;
        // 멤버 변수 생성
        this.memberService = memberService;
    }

    //Create
    @PostMapping("/api/members/add")
    public Member createMember(@RequestBody MemberRequestDto requestDto) throws SQLException {
        Member member = memberService.createMember(requestDto);
        return member;
    }

    //Read  멤버 조회
   @GetMapping("/api/members")
    public List<Member> getMember() {
        return memberRepository.findAll();
    }

    //Read
    @GetMapping("/api/search/{id}")
    public Long getMemberid(@PathVariable Long id) {
        memberRepository.getById(id);
        return id;
    }

//    //Read  /// 초기모델
//    @GetMapping("/api/search/{id}")
//    public List<Member> getMemberid(@PathVariable Long id) {
//        memberRepository.getById(id);
//        return id;
//    }


    // Update
    @PutMapping("/api/members/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemberRequestDto requestDto) {
        memberService.update(id, requestDto);
        return id;
        //member.getId();
    }
    // 아래와 같은 방법으로도 가능 naverapi_controller
    //    // 설정 가격 변경
    //    @PutMapping("/api/products/{id}")
    //    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
    //        //ProductService productService = new ProductService(); // 중복 삭제
    //        Product product = productService.updateProduct(id, requestDto);
    //        return product.getId();
    //    }


    //Delete
    @DeleteMapping("/api/members/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memberRepository.deleteById(id);
        return id;
    }
}