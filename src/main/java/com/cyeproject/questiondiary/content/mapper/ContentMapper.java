package com.cyeproject.questiondiary.content.mapper;

import com.cyeproject.questiondiary.content.dto.ContentPatchDto;
import com.cyeproject.questiondiary.content.dto.ContentPostDto;
import com.cyeproject.questiondiary.content.dto.ContentResponseDto;
import com.cyeproject.questiondiary.content.entity.Content;
import org.mapstruct.Mapper;

//Mapper 클래스의 역할
//1. Controller 클래스 내의 핸들러 메서드와 객체의 타입을 변환하는 작업을 분리합니다.
//-> Controller 클래스는 외부와 통신을 하는 계층입니다. 데이터형 변환은 살짝 벗어나는 작업이에요.
//2. DTO 클래스와 엔티티 클래스의 역할 분리
//-> 두 클래스의 관심사(하나는 외부와의 통신, 하나는 비즈니스 로직처리)는 다릅니다. 분리를 해주어야해요

//@Mapper : 이 인터페이스를 MapStruct의 매퍼 인터페이스로 정의합니다.
//-> 그럼 MapStruct가 이 인터페이스를 기반으로 구현 클래스를 자동 생성해줍니다.
//componentModel = "spring" : 스프링 빈으로 등록을 하겠습니다.
@Mapper(componentModel = "spring")
public interface ContentMapper {
    //이곳에 메서드를 적어주어요
    //1. 엔티티 클래스 객체를 DTO 클래스 객체로 변경하는 메서드
    //-> 비즈니스 로직을 처리한 결과를 클라이언트에게 보낼 응답 객체로 변경
    //2. DTO 클래스 객체를 엔티티 클래스 객체로 변경하는 메서드 
    //-> 요청에서 주어지는 데이터를 DTO 클래스 객체로 받아서 요청을 처리하기 위해 엔티티 클래스 객체로 변경
    //ex. Content contentPostDtoContent(ContentPostDto contentPostDto);
    // - Post 요청을 받았을 때 같이 오는 데이터를 DTO 객체로 받고, 그걸 DB에 저장하기 위해 엔티티 객체로 변경합니다.
    Content contentPostDtoToContent(ContentPostDto contentPostDto);
    Content contentPatchDtoToContent(ContentPatchDto contentPatchDto);
    ContentResponseDto contentToContentResponseDto(Content content);
}