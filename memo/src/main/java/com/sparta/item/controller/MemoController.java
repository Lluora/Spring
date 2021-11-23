package com.sparta.item.controller;

import com.sparta.item.domain.Memo;
import com.sparta.item.domain.MemoRepository;
import com.sparta.item.dto.MemoRequestDto;
import com.sparta.item.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {
    // 뭐 갖고올껀지, api 쓰는게 controller 코드인 것 같음

    private final MemoRepository memoRepository;
    private final MemoService memoService; // // Put은 Service단에서 갖고오므로


    //Create
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }


    //Read
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        //LocalDateTime start = LocalDateTime.now().minusDays(1); //1시간
        LocalDateTime start = LocalDateTime.now().minusMinutes(1); //1분

        LocalDateTime end = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
        //return memoRepository.findAllByOrderByModifiedAtDesc();
    }


    // Update
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }


    //Delete
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}