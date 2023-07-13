package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    @Query(
        "SELECT m " +
            "FROM Member m " +
            "WHERE m.id IN ( " +
            " SELECT t.member.id " +
            " FROM Team t " +
            " WHERE t.subject.id IN :subjectIds " +
            ")"
    )
    List<Member> findTeamMemberBySubject(List<Long> subjectIds);

}
