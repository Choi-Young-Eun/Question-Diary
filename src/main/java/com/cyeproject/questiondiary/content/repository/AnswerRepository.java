package com.cyeproject.questiondiary.content.repository;

import com.cyeproject.questiondiary.content.entity.Answer;
import com.cyeproject.questiondiary.content.entity.AnswerID;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository <Answer, AnswerID> {
    List<Answer> findAllByContentDate(String contentDate);
}
