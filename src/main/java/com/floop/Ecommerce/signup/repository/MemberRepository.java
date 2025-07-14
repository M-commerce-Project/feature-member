package com.floop.Ecommerce.signup.repository;

import com.floop.Ecommerce.signup.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 아이디 중복 여부 확인
    boolean existsByUserId(String userId);

    // 아이디로 회원 정보 조회
    Optional<Member> findByUserId(String userId);

}
