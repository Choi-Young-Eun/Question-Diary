package com.cyeproject.questiondiary.content.entity;

import com.cyeproject.questiondiary.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="content")
public class Content {
    /*
    1. 글 ID : long - 기본키
    -> DB에 데이터를 저장할 때 자동으로 채워집니다
    2. 날짜 : date 음... 이걸 뭘로 하지
    ----> 그냥 날짜를 기본키로 할까
    3. 글쓴이 ID : String
    4. 질문내용과 답 쌍들 : List<Question> ?
    -> 이걸 어떻게 처리하지? 흠..
    5. 기분 값 : int(Integer?)
    6. 오늘의 문장 : String
    
    */
//    @Id
//    @Column(name = "content_id")
//    private Long contentId;
    @Id
    private String contentDate;
   // @ManyToOne //이거 제대로 설정하기
   // @JoinColumn(name = "member_id")
   // private String writer; //외래키
    //컬럼으로 생성 안함) - 연결하기 매핑!
    @OneToMany(mappedBy = "content")
    private List<Answer> qnas;
    private Long feeling;
    @Column(name = "today_sentence")
    private String todaySentence;
}
