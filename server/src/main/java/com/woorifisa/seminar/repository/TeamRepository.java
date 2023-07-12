package com.woorifisa.seminar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woorifisa.seminar.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Team.Id> {

	List<Team> findBySubjectId(Long id);

}
