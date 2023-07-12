package com.woorifisa.seminar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woorifisa.seminar.entity.EstimationItem;

@Repository
public interface EstimationRepository extends JpaRepository<EstimationItem, Long>{
	
	List<EstimationItem> findEstimationItemsByIsOtherIsFalseOrderByOrder();

}
