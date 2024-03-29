package com.cyeproject.questiondiary.content.entity;

import com.cyeproject.questiondiary.question.entity.Question;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@IdClass(AnswerID.class)
@Table(name = "answer")
public class Answer{
    /*
    1. 글 ID : Long (기,외) - 필수
    2. 질문 ID : Long (기,외) - 필수
    3. 질문 답 : String
    */
    @Id
    @Column(name = "content_date", nullable = false)
    private String contentDate;

    @Id
    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "content_date") //DB테이블(answer)에 외래키가 이런식으로 이름이 들어가유
    private Content content;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name="answer_content")
    private String answer;
}
