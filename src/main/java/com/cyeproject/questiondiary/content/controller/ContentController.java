package com.cyeproject.questiondiary.content.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//API 계층 - 외부와 통신을 합니다. 요청을 받고 응답을 내보내는 계층입니다.
@RestController //Rest API의 자원을 처리하기 위한 API 엔드포인트로 동작합니다.
@RequestMapping("/diary/content") //URL 정하기. 핸들러 메서드를 매핑해줍니다.
public class ContentController {

    //생성자
    // : mapper클래스(데이터 타입 변경 목적)와 service클래스(비즈니스 로직 처리 목적)의 객체를 DI 받아요

    //**아직 DTO랑 Mapper를 구현하지 않아서 매개변수는 고따구로 밖에 못했음!
    //1. 글 작성 - post
    @PostMapping
    public ResponseEntity postContent(@RequestParam("memberId") long memberId){
        //매개변수에서 바디의 파라미터값을 DTO로 받습니다.
        //Mapper를 통해 Dto를 Entity로 바꿉니다.
        //바꾼 Entity를 Service Layer 클래스의 메서드를 이용하여 넘겨줍니다.
        //Service Layer에서 비즈니스 로직을 모두 처리하면 여기로 다시 돌아와요
        //받은 결과 객체(생성된 다이어리 글)를
        //클라이언트에게 보낼 응답 메시지를 구성해서 return 해요
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //2. 글 수정 - patch
    @PatchMapping("/{content-number}")
    public ResponseEntity patchContent(@PathVariable("content-number") long contentNumber, @RequestParam("memberId") long memberId){
        //매개변수로 요청에 담긴 수정할 정보를 DTO 클래스 객체에 담음
        //DTO 객체를 Entity 객체로 변경
        //Service Layer 호출 : Entity 객체도 같이 넘겨주기!
        //받은 결과 객체(다이어리 글이겠지?)를 DTO 클래스 객체로 변경
        //DTO 클래스 객체를 포함한 응답 객체 구성해서 return!
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //3. 글 조회 (하나만) - get
    @GetMapping("/{content-number}")
    public ResponseEntity getContent(@PathVariable("content-number") long contentNumber){
        //Service Layer 호출
        //받은 객체 DTO로 바꿈
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //4. 글 삭제 - delete
    @DeleteMapping("/{content-number}")
    public ResponseEntity deleteeContent(@PathVariable("content-number") long contentNumber) {
        //Service Layer 호출
        //객체를 받지는 않을테니까 잘 지워졌다고 응답 메시지만 잘 작성해서 던져주기
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
