package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.entity.MemberEntity;
import com.portfolio.trip_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        return memberRepository.save(memberEntity).getId();
    }

    public boolean userNameCheck(String memberUserName) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberUserName(memberUserName);
        if(optionalMemberEntity.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
 }
