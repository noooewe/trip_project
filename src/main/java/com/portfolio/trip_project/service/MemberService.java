package com.portfolio.trip_project.service;

import com.portfolio.trip_project.config.PasswordEncoderConfig;
import com.portfolio.trip_project.dto.MemberDTO;
import com.portfolio.trip_project.entity.MemberEntity;
import com.portfolio.trip_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoderConfig.PasswordEncoder passwordEncoder;

    public Long save(MemberDTO memberDTO) {
        memberDTO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);

        return memberRepository.save(memberEntity).getId();
    }

    public boolean login(MemberDTO memberDTO) {
        Optional<MemberEntity> memberEntity =
                memberRepository.findByMemberUserName(memberDTO.getMemberUserName());

        if (memberEntity.isPresent()) {
            return passwordEncoder.matches(memberDTO.getMemberPassword(), memberEntity.get().getMemberPassword());
        } else {
            return false;
        }
    }

    public void loginAxios(MemberDTO memberDTO) {
        MemberEntity memberEntity = memberRepository.findByMemberUserName(memberDTO.getMemberUserName())
                .orElseThrow(() -> new NoSuchElementException("계정 또는 비밀번호가 틀립니다"));

        if (!passwordEncoder.matches(memberDTO.getMemberPassword(), memberEntity.getMemberPassword())) {
            throw new NoSuchElementException("계정 또는 비밀번호가 틀립니다");
        }
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

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity memberEntity: memberEntityList) {
            memberDTOList.add(MemberDTO.toDTO(memberEntity));
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        MemberEntity memberEntity = memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
        return MemberDTO.toDTO(memberEntity);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public MemberDTO findByMemberUserName(String loginUserName) {
        MemberEntity memberEntity = memberRepository.findByMemberUserName(loginUserName).orElseThrow(() -> new NoSuchElementException());
        return MemberDTO.toDTO(memberEntity);
    }

    public void update(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toUpdateEntity(memberDTO);
        memberEntity.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        memberRepository.save(memberEntity);
    }



}