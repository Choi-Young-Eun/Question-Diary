package com.cyeproject.questiondiary.content.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode//(onlyExplicitlyIncluded = true)
public class AnswerID implements Serializable {
    @EqualsAndHashCode.Include
    private String contentDate;
    @EqualsAndHashCode.Include
    private Long questionId;
}
