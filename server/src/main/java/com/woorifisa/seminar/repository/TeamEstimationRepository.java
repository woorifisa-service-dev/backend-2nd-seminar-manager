package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.dto.result.ResultInfoResponse;
import com.woorifisa.seminar.entity.Subject;
import com.woorifisa.seminar.entity.TeamEstimation;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamEstimationRepository extends JpaRepository<TeamEstimation, Long> {

	@Query(
			"SELECT " + 
			"te.id " +
			
			"FROM " + 
			"TeamEstimation te" + 
			" JOIN te.subject s " +

			"WHERE" + 
			" te.targetMemberNo = :sessionUserId" + 
			" AND s.id = :subjectId "
			)
	List<Long> findByIdAndSubjectId(@Param("sessionUserId") Long sessionUserId, @Param("subjectId") Long subjectId);

}
