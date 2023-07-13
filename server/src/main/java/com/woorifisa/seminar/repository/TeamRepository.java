package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.Team;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Team.Id> {

    List<Team> findBySubjectId(Long id);

    @Query(
        "SELECT t " +
            "FROM Team t JOIN FETCH t.member " +
            "WHERE t.subject IN :subjectIds "
    )
    List<Team> findMemberBySubject(List<Long> subjectIds);

}
