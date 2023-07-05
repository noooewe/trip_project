package com.portfolio.trip_project.service;

import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.entity.ERole;
import com.portfolio.trip_project.entity.MemberEntity;
import com.portfolio.trip_project.entity.RoleEntity;
import com.portfolio.trip_project.repository.MemberRepository;
import com.portfolio.trip_project.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    public Long save(MemberDTO memberDTO) {
        memberDTO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);

        if (memberDTO.getMemberUserName().equals("admin123")) {
            // 관리자 역할 추가
            RoleEntity adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
            if (adminRole == null) {
                logger.error("ROLE_ADMIN not found.");
            } else {
                logger.info("ROLE_ADMIN: {}", adminRole);
                memberEntity.getRoles().add(adminRole);
            }
        } else {
            // 사용자 역할 추가
            RoleEntity userRole = roleRepository.findByName(ERole.ROLE_USER);
            if (userRole == null) {
                logger.error("ROLE_USER not found.");
            } else {
                logger.info("ROLE_USER: {}", userRole);
                memberEntity.getRoles().add(userRole);
            }
        }

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

    public boolean loginAxios(MemberDTO memberDTO) {
        MemberEntity memberEntity = memberRepository.findByMemberUserName(memberDTO.getMemberUserName())
                .orElseThrow(() -> new NoSuchElementException("아이디가 틀립니다."));
        if(!passwordEncoder.matches(memberDTO.getMemberPassword(), memberEntity.getMemberPassword())) {
            throw new NoSuchElementException("비밀번호가 틀립니다.");
        }
        return true;
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