package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
