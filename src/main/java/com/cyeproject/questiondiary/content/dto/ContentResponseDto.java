package com.cyeproject.questiondiary.content.dto;

import com.cyeproject.questiondiary.content.entity.Answer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ContentResponseDto {
    /*
    1. 날짜
    2. 질문내용과 답 쌍들
    -> 이걸 어떻게 처리하지? 흠..
    3. 기분 값
    4. 오늘의 문장
    */
    private String contentDate;
    private List<AnswerResponseDto> qnas;
    private Long feeling;
    private String todaySentence;
}
