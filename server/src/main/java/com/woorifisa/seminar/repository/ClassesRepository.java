package com.woorifisa.seminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.woorifisa.seminar.entity.Clazz;

@Repository
public interface ClassesRepository extends JpaRepository<Clazz, Long>{
	

}
