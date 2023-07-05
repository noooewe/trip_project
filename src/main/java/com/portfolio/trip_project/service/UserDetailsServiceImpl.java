package com.portfolio.trip_project.service;

import com.portfolio.trip_project.config.MemberDetails;
import com.portfolio.trip_project.entity.MemberEntity;
import com.portfolio.trip_project.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    public UserDetailsServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (userName == null || userName.trim().isEmpty()) {
            throw new UsernameNotFoundException("아이디가 비어있습니다.");
        }

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberUserName(userName);
        MemberEntity memberEntity = optionalMemberEntity.orElseThrow(() -> new UsernameNotFoundException("아이디가 틀립니다."));
        return new MemberDetails(memberEntity);
    }
}