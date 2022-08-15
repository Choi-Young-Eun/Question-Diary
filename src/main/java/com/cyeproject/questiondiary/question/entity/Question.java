package com.cyeproject.questiondiary.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    /*
    1. 질문 id : question_id
    2. 질문 내용 : question_content
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
    private Long questionId;
    @Column(name="question_content")
    private String questionContent;
}
