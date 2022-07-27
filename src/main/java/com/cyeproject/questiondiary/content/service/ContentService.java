package com.cyeproject.questiondiary.content.service;

import com.cyeproject.questiondiary.content.entity.Content;
import org.springframework.stereotype.Service;

@Service
public class ContentService {
    public Content createContent(Content content){
        //DB에 접근해서 저장하고 되돌려받아오기!
        return null;
    }

    public Content updateContent(Content content){
        //DB에 접근해서 수정한 값을 저장하고 되받아오기!
        //-> 채워진 값들만 수정할 수 있도록 그리고 그 수정 후의 값을 반환!
        return null;
    }

    public Content findContent(long contentId){
        //id 값을 이용해서 DB에서 다이어리글을 가져와서 반환!
        return null;
    }

    public void deleteContent(long contentId){
        //id 값을 이용해서 DB에서 상태를 변경하고 오기(ex. 작성완료에서 삭제로)
    }
}
