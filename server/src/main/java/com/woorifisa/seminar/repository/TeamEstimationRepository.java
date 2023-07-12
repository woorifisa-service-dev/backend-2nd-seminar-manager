package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.TeamEstimation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamEstimationRepository extends JpaRepository<TeamEstimation, Long> {

}
