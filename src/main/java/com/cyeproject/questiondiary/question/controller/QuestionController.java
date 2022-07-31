package com.cyeproject.questiondiary.question.controller;

import com.cyeproject.questiondiary.question.entity.Question;
import com.cyeproject.questiondiary.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/diary/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }


    //*************************** 여긴 아직 DTO 시작도 안함!
    //C
    @PostMapping
    public ResponseEntity postQuestion(@RequestParam("question_content") String content){
        //Service를 통해 저장해요
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //R1 - All
    @GetMapping
    public ResponseEntity getQuestions(){
        List<Question> result = questionService.findAllQuestion();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //R2 - One (필요가 있나?)
    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") Long questionId){
        //Service를 통해 id에 맞는 것만 가져와요
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //U
    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(){
        //수정 버튼을 누르고
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //D
    public ResponseEntity deleteQuestion(Long questionId){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
