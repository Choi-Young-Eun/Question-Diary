package com.cyeproject.questiondiary.content.dto;

import com.cyeproject.questiondiary.question.entity.Question;

import java.util.List;

public class ContentPatchDto {
    /*
    //3-5는 비어있을 수 있음 필수 값 아님!
    1. 글 ID - Long : 필수
    2. 글쓴이 ID - String : 필수
    3. 질문의 답들 - 여러개.
    -> 근데 바꿀 수도 안바꿀 수도.. 와 이게 애매하네
    4. 기분 값 - 숫자
    5. 오늘의 문장 - String
    */
    private long content_id;
    private String writer;
    private List<Question> qnas;
    private int feeling;
    private String today_sentence;
}
