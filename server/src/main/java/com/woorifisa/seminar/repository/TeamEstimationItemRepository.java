package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.TeamEstimationItem;
import com.woorifisa.seminar.entity.constant.Type;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamEstimationItemRepository extends JpaRepository<TeamEstimationItem, TeamEstimationItem.Id> {

	@Query(
			"SELECT " +
			"tei.score "+
	
			"FROM " +
			"TeamEstimationItem tei "+ 
			"JOIN tei.teamEstimation te "+
			
			"WHERE "+
			"te.id IN :targeteamEstimation"
					)
	List<Long> targetScore(@Param("targeteamEstimation") List<Long> targeteamEstimation);
}
