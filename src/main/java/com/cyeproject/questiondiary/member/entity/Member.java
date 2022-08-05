package com.cyeproject.questiondiary.member.entity;

import com.cyeproject.questiondiary.content.entity.Content;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Member {
    //기본키
    @Id
    @Column(name = "member_id")
    private String memberId;
    @Column(name = "member_pw")
    private String memberPw;
    private String name;
    private String phone;
    private String email;
  //  @OneToMany(mappedBy = "writer")
  //  private List<Content> contents;
    //회원 상태 추가! 가입 휴면 (탈퇴)
}

