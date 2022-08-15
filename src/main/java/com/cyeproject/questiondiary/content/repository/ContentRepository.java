package com.cyeproject.questiondiary.content.repository;

import com.cyeproject.questiondiary.content.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, String> {
}
