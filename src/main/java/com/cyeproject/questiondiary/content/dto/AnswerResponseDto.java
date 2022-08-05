package com.cyeproject.questiondiary.content.dto;

import lombok.Setter;

@Setter
public class AnswerResponseDto {
    private Long questionId;
    private String questionContent;
    private String answer;
}
