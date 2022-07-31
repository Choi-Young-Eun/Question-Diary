package com.cyeproject.questiondiary.content.service;

import com.cyeproject.questiondiary.content.entity.Answer;
import com.cyeproject.questiondiary.content.entity.Content;
import com.cyeproject.questiondiary.content.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    public List<Answer> createAnswers(List<Answer> answers, Content content){
        //answers 하나하나 돌면서 content_id를 넣음
        //DTO로 올때 Question 부분도 id만 채워져서 옴!!! 그건 이미 answers에 각각 담겨있음
        List<Answer> result = answers.stream().map(answer -> {
            answer.setContent(content);
            return answerRepository.save(answer);
        }).collect(Collectors.toList());

        return result;
    }

    //********************** sudo code 짜는중
    public List<Answer> updateAnswer(List<Answer> answers){
        //answers에는 수정할 것들만 담겨져 있겠지?
        //save를 해줄 거니까
        return null;
    }
}
