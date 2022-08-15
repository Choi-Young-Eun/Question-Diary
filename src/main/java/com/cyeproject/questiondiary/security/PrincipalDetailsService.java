package com.cyeproject.questiondiary.security;

import com.cyeproject.questiondiary.member.entity.Member;
import com.cyeproject.questiondiary.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //무슨 애너테이션인지 찾기
public class PrincipalDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Member memberEntity = memberRepository.findByUsername(name);
        return new PrincipalDetails(memberEntity);
    }
}
