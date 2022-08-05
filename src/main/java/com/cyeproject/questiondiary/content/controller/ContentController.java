package com.cyeproject.questiondiary.content.controller;

import com.cyeproject.questiondiary.content.dto.ContentPatchDto;
import com.cyeproject.questiondiary.content.dto.ContentPostDto;
import com.cyeproject.questiondiary.content.entity.Content;
import com.cyeproject.questiondiary.content.mapper.ContentMapper;
import com.cyeproject.questiondiary.content.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//API 계층 - 외부와 통신을 합니다. 요청을 받고 응답을 내보내는 계층입니다.
@RestController //Rest API의 자원을 처리하기 위한 API 엔드포인트로 동작합니다.
@RequestMapping("/diary/content") //URL 정하기. 핸들러 메서드를 매핑해줍니다.
public class ContentController {

    private final ContentService contentservice;
    private final ContentMapper mapper;

    //생성자
    // : mapper클래스(데이터 타입 변경 목적)와 service클래스(비즈니스 로직 처리 목적)의 객체를 DI 받아요
    public ContentController(ContentService contentService, ContentMapper mapper){
        this.contentservice = contentService;
        this.mapper = mapper;
    }

    //********************************** DTO랑 Mapper구현 덜 됐습니당gi
    //1. 글 작성 - post
    @PostMapping
    public ResponseEntity postContent(@RequestBody ContentPostDto contentPostDto){
        //매개변수에서 바디의 파라미터값을 DTO로 받습니다.
        //Mapper를 통해 Dto를 Entity로 바꿉니다.
        Content content=mapper.contentPostDtoToContent(contentPostDto);
        //바꾼 Entity를 Service Layer 클래스의 메서드를 이용하여 넘겨줍니다.
        //Service Layer에서 비즈니스 로직을 모두 처리하면 여기로 다시 돌아와요
        Content result=contentservice.createContent(content);
        //받은 결과 객체(생성된 다이어리 글)를
        //클라이언트에게 보낼 응답 메시지를 구성해서 return 해요
        return new ResponseEntity<>(mapper.contentToContentResponseDto(result),HttpStatus.CREATED);
    }

    //2. 글 수정 - patch (아직 안함)
    @PatchMapping("/{content-date}")
    public ResponseEntity patchContent(@PathVariable("content-date") String contentDate, @RequestBody ContentPatchDto contentPatchDto){
        //매개변수로 요청에 담긴 수정할 정보를 DTO 클래스 객체에 담음
        //DTO 객체를 Entity 객체로 변경
        Content content = mapper.contentPatchDtoToContent(contentPatchDto);
        //Service Layer 호출 : Entity 객체도 같이 넘겨주기!
        Content result=contentservice.updateContent(content,contentDate);
        //받은 결과 객체(다이어리 글이겠지?)를 DTO 클래스 객체로 변경
        //DTO 클래스 객체를 포함한 응답 객체 구성해서 return!
        return new ResponseEntity<>(mapper.contentToContentResponseDto(result),HttpStatus.OK);
    }

    //3. 글 조회 (하나만) - get
    @GetMapping("/{content-date}")
    public ResponseEntity getContent(@PathVariable("content-date") String contentDate){
        //Service Layer 호출
        Content content = contentservice.findContent(contentDate);
        //받은 객체 DTO로 바꿈 - 아직 안됨. 수정해야됨
        return new ResponseEntity<>(mapper.contentToContentResponseDto(content),HttpStatus.OK);
    }

    //4. 글 삭제 - delete (근데 아직 answer지우는 건 처리 못함)
    @DeleteMapping("/{content-date}")
    public ResponseEntity deleteContent(@PathVariable("content-date") String contentDate) {
        //Service Layer 호출
        contentservice.deleteContent(contentDate);
        //객체를 받지는 않을테니까 잘 지워졌다고 응답 메시지만 잘 작성해서 던져주기
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
