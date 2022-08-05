package com.cyeproject.questiondiary.content.dto;

import lombok.Getter;


@Getter
public class AnswerRequestDto {
    private Long questionId;
    private String answer;
}
