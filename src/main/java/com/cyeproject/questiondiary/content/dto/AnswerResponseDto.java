package com.cyeproject.questiondiary.content.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerResponseDto {
    private Long questionId;
    private String questionContent;
    private String answer;
}
