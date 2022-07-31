package com.cyeproject.questiondiary.content.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerID implements Serializable {
    private Long contentId;
    private Long questionId;
}
