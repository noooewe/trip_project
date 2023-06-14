package com.portfolio.trip_project.repository;

import com.portfolio.trip_project.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByMemberUserName(String memberUserName);

    Optional<MemberEntity> findByMemberUserNameAndMemberPassword(String memberEmail, String memberPassword);
}
