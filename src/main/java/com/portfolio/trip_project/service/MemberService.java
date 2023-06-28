package com.portfolio.trip_project.service;

import com.portfolio.trip_project.config.MemberDetails;
import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.entity.MemberEntity;
import com.portfolio.trip_project.repository.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Long save(MemberDTO memberDTO) {
        memberDTO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        return memberRepository.save(memberEntity).getId();
    }

    public boolean login(MemberDTO memberDTO) {
        Optional<MemberEntity> memberEntity =
                memberRepository.findByMemberUserName(memberDTO.getMemberUserName());
        if (memberEntity.isPresent() && passwordEncoder.matches(memberDTO.getMemberPassword(), memberEntity.get().getMemberPassword())) {
            return true;
        } else {
            return false;
        }
    }
    public void loginAxios(MemberDTO memberDTO) {
        MemberEntity memberEntity = memberRepository.findByMemberUserName(memberDTO.getMemberUserName())
                .orElseThrow(() -> new NoSuchElementException("아이디가 틀립니다."));
        if(!passwordEncoder.matches(memberDTO.getMemberPassword(), memberEntity.getMemberPassword())) {
            throw new NoSuchElementException("비밀번호가 틀립니다.");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberUserName(username);
        MemberEntity memberEntity = optionalMemberEntity.orElseThrow(() -> new UsernameNotFoundException("아이디가 틀립니다."));
        return new MemberDetails(memberEntity);
    }


    public boolean userNameCheck(String memberUserName) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberUserName(memberUserName);
        if(optionalMemberEntity.isPresent()) {
            return false;
        } else {
            return true;
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
