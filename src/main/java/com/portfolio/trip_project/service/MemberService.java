package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.entity.MemberEntity;
import com.portfolio.trip_project.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        return memberRepository.save(memberEntity).getId();
    }

    public boolean login(MemberDTO memberDTO) {
        Optional<MemberEntity> memberEntity =
                memberRepository.findByMemberUserNameAndMemberPassword(memberDTO.getMemberUserName(), memberDTO.getMemberPassword());
        if (memberEntity.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public void loginAxios(MemberDTO memberDTO) {
        memberRepository.findByMemberUserNameAndMemberPassword(memberDTO.getMemberUserName(), memberDTO.getMemberPassword())
                .orElseThrow(() -> new NoSuchElementException("아이디 또는 비밀번호가 틀립니다."));
    }



    public boolean userNameCheck(String memberUserName) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberUserName(memberUserName);
        if(optionalMemberEntity.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean passPortNumCheck(String memberPassportNum) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberPassportNum(memberPassportNum);
        if(optionalMemberEntity.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
 }
