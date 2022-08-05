package com.cyeproject.questiondiary.member.mapper;

import com.cyeproject.questiondiary.member.dto.MemberPostDto;
import com.cyeproject.questiondiary.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
}
