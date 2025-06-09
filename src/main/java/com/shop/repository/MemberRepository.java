package com.shop.repository;

import com.shop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    //Member엔티티 데베에 저장할수있도록 리포지토리 생성

    Member findByEmail(String email);

}
