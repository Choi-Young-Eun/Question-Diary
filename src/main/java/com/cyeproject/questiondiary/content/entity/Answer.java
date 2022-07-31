package com.cyeproject.questiondiary.content.entity;

import com.cyeproject.questiondiary.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(AnswerID.class)
@Table(name = "answer")
public class Answer implements Serializable {
    /*
    1. 글 ID : Long (기,외) - 필수
    2. 질문 ID : Long (기,외) - 필수
    3. 질문 답 : String
    */
    @Id
    @ManyToOne
    @JoinColumn(name = "content_date") //DB테이블(answer)에 외래키가 이런식으로 이름이 들어가유
    private Content content;
    //private Long contentId;

    @Id
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private String answer;
}
