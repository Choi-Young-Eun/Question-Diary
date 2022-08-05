package com.cyeproject.questiondiary.member.repository;

import com.cyeproject.questiondiary.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
}
