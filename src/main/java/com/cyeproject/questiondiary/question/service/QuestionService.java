package com.cyeproject.questiondiary.question.service;

import com.cyeproject.questiondiary.question.entity.Question;
import com.cyeproject.questiondiary.question.repository.QuestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    //C
    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }
    //R1
    public List<Question> findAllQuestion(){
        return questionRepository.findAll(); //pagenation 적용 X
    }
    //R2
    public Question findQuestion(Long question_id){
        //질문 있는지 확인
        verifyExistsQuestionId(question_id);
        return questionRepository.findById(question_id).get(); //Optional<Quesion>이 넘어와서 get()을 해줍니다.
    }
    //U
    public Question updateQuestion(Question question){
        //질문있는지 확인
        verifyExistsQuestionId(question.getQuestion_id());
        return questionRepository.save(question);
    }
    //D
    public void deleteQuestion(Long question_id){
        //질문있는지 확인 - 좀 이상함 수정 필요!
        verifyExistsQuestionId(question_id);
        questionRepository.deleteById(question_id);
    }

    //id에 해당하는 질문이 있는지 확인
    private void verifyExistsQuestionId(Long question_id) {
        Optional<Question> question = questionRepository.findById(question_id);
        if (question.isPresent())
            //예외처리 - 아직 안됨
            System.out.println("해당하는 id가 없습니다.");
    }
}
