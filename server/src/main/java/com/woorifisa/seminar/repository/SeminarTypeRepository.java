package com.woorifisa.seminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woorifisa.seminar.entity.SeminarType;

@Repository
public interface SeminarTypeRepository extends JpaRepository<SeminarType, Long>{

}
