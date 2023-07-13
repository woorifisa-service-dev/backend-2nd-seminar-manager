package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.OtherEstimationItem;
import com.woorifisa.seminar.entity.constant.Type;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherEstimationItemRepository extends JpaRepository<OtherEstimationItem, OtherEstimationItem.Id> {

	@Query(
		    "SELECT " +
		        "SUM(oei.score) " +

		        "FROM " +
		        "OtherEstimationItem oei " +
		        " JOIN oei.otherEstimation oe " +

		        "WHERE " +
		        " oei.roleName = :role" +
		        " AND oe.id IN :targetOtherEstimation " +

		        "GROUP BY oei.roleName"
		)
		Long targetScore(@Param("targetOtherEstimation") List<Long> targetOtherEstimation, @Param("role") Type role);
}
