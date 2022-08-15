package com.cyeproject.questiondiary.member.entity;

import com.cyeproject.questiondiary.content.entity.Content;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    //기본키
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "member_pw")
    private String password;
    private String username;
    private String phone;
    private String email;

    private String roles; //USER, MANAGER, ADMIN

    //역할이 여러개 있다고 가정할껀가봐
    public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
  //  @OneToMany(mappedBy = "writer")
  //  private List<Content> contents;
    //회원 상태 추가! 가입 휴면 (탈퇴)
}

