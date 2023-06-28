package com.portfolio.trip_project.repository;

import com.portfolio.trip_project.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByMemberUserName(String memberUserName);

    Optional<MemberEntity> findByMemberPassportNum(String memberPassportNum);

    Optional<MemberEntity> findByMemberUserNameAndMemberPassword(String memberEmail, String memberPassword);
}
