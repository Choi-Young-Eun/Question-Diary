package com.cyeproject.questiondiary.content.repository;

import com.cyeproject.questiondiary.content.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface AnswerRepository extends JpaRepository <Answer, Id> {
}
