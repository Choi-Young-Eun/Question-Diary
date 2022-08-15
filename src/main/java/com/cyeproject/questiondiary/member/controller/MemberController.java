package com.cyeproject.questiondiary.member.controller;

import com.cyeproject.questiondiary.member.dto.MemberPostDto;
import com.cyeproject.questiondiary.member.entity.Member;
import com.cyeproject.questiondiary.member.mapper.MemberMapper;
import com.cyeproject.questiondiary.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary/member")
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService,MemberMapper mapper){
        this.memberService=memberService;
        this.mapper=mapper;
    }

    //C - 회원 가입
    @PostMapping("/join")
    public ResponseEntity joinMember(@RequestBody MemberPostDto memberPostDto){
        Member member=mapper.memberPostDtoToMember(memberPostDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity loginMember(@RequestBody MemberPostDto memberPostDto){
        Member member=mapper.memberPostDtoToMember(memberPostDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    //R - 내 정보 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //U - 회원 정보 수정
    //
    //D - 회원 탈퇴
}
