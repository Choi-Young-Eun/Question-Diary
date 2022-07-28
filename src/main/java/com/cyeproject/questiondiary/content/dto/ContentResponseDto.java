package com.cyeproject.questiondiary.content.dto;

import com.cyeproject.questiondiary.question.entity.Question;

import java.util.List;

public class ContentResponseDto {
    /*
    1. 날짜
    2. 질문내용과 답 쌍들
    -> 이걸 어떻게 처리하지? 흠..
    3. 기분 값
    4. 오늘의 문장
    */
    private String created_date;
    private List<Question> qnas;
    private int feeling;
    private String today_sentence;
}
