package com.cyeproject.questiondiary.content.entity;

import com.cyeproject.questiondiary.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    /*
    1. 글 ID : long - 기본키
    -> DB에 데이터를 저장할 때 자동으로 채워집니다
    2. 날짜 : date 음... 이걸 뭘로 하지
    3. 글쓴이 ID : String
    4. 질문내용과 답 쌍들 : List<Question> ?
    -> 이걸 어떻게 처리하지? 흠..
    5. 기분 값 : int(Integer?)
    6. 오늘의 문장 : String
    
    */
    private long content_id;
    private String created_date;
    private String writer;
    private List<Question> qnas;
    private int feeling;
    private String today_sentence;
}
