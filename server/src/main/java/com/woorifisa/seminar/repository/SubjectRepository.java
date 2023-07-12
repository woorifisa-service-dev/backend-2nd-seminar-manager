package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.SeminarType;
import com.woorifisa.seminar.entity.Subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
	List<Subject> findBySeminarTypeOrderByOrder(SeminarType targetSeminar);
}
