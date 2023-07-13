package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.OtherEstimation;
import com.woorifisa.seminar.entity.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherEstimationRepository extends JpaRepository<OtherEstimation, Long> {

	List<OtherEstimation> findBySubject(Subject subject);
}
