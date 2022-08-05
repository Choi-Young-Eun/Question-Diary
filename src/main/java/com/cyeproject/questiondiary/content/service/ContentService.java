package com.cyeproject.questiondiary.content.service;

import com.cyeproject.questiondiary.content.entity.Answer;
import com.cyeproject.questiondiary.content.entity.Content;
import com.cyeproject.questiondiary.content.repository.ContentRepository;
import com.cyeproject.questiondiary.question.entity.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepository contentRepository;
    private final AnswerService answerService;
    //question repository 필요
    public ContentService(ContentRepository contentRepository,AnswerService answerService){
        this.contentRepository=contentRepository;
        this.answerService=answerService;
    }

    public Content createContent(Content content){
        //DB에 접근해서 저장하고 되돌려받아오기!
        //1. 글 부분 채우기
        //Date date = new Date();
        String dateToString = String.format("%1$tY%1$tm%1$td", new Date());
        content.setContentDate(dateToString);
        Content result=contentRepository.save(content);
        //2. 댓글 부분 채우기
        //-> 글 저장하고 생성된 content_id 받아서 주고 List<Answer> 채우기
        List<Answer> answers=answerService.createAnswers(result.getQnas(),result);
        //Answer들 하나하나 content_id에 result.getContent_id()로 채워넣고
        //List<Answer> result_answer=answerRepository.saveAll(answers); -> List<Answer> answers=answerRepository.saveAll(result.getQnas());
        //-> 근데 여기서 repository를 부르는게 맞나? service를 호출해야되나.. 알맹이를 보내줄때 질문내용도 보여줘야될텐데 이건 어떻게 되는거지
        //-> Service 호출함
        result.setQnas(answers);
        return result;
    }

    public Content updateContent(Content content,String contentDate){
        content.setContentDate(contentDate);
        verifyExistsContentDate(contentDate); //그 날짜에 맞는 다이어리가 있는지
        //있다고 치고!
        List<Answer> updatedAnswers=answerService.updateAnswer(content.getQnas());
        content.setQnas(updatedAnswers);
        //DB에 접근해서 수정한 값을 저장하고 되받아오기!
        //-> 채워진 값들만 수정할 수 있도록 그리고 그 수정 후의 값을 반환!
        return contentRepository.save(content);
    }

    public Content findContent(String contentDate){
        //id 값을 이용해서 DB에서 다이어리글을 가져와서 반환!
        verifyExistsContentDate(contentDate);
        Content content = contentRepository.findById(contentDate).get();
        content.setQnas(answerService.findAnswer(contentDate));
        //존재하는지 확인하는 메서드 만들면 위에 두줄 지우고 그걸로 대체하기!
        return content;
    }

    public void deleteContent(String contentDate){
        //id 값을 이용해서 DB에서 상태를 변경하고 오기(ex. 작성완료에서 삭제로)
        verifyExistsContentDate(contentDate); //예외처리할 때 수정하기 - 존재하는지 확인하고 있으면 객체를 반환하는 메서드를 사용하기
        answerService.deleteAnswer(contentDate);
        contentRepository.deleteById(contentDate); //예외처리 되면 deleteById가 아니라 위에서 결과로 받은 객체 사용해서 delete메서드 사용하기
    }

    //예외처리할 때 수정하기 : 메서드 하나 만들어야됨
    //- ContentDate값으로 DB에서 데이터 조회하고 존재하는지 확인!
    //- 있으면 객체를 반환하는 메서드를 만들기!

    private void verifyExistsContentDate(String contentDate) {
        Optional<Content> content =  contentRepository.findById(contentDate);
        if (content.isPresent())
            //예외처리 - 아직 안됨
            System.out.println("해당하는 content가 없습니다.");
    }
}
