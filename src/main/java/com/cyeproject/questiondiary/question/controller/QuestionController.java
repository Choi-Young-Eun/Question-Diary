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
    public ResponseEntity postQuestion(@RequestBody Question question){
        questionService.createQuestion(question);
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
    public ResponseEntity patchQuestion(@PathVariable("question-id") Long questionId, @RequestParam("question-content") String questionContent){
        //수정 버튼을 누르고
        questionService.updateQuestion(questionId,questionContent);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //D
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") Long questionId){
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
