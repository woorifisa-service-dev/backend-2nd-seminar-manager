package com.woorifisa.seminar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.woorifisa.seminar.entity.Clazz;

@Repository
public interface ClassesRepository extends JpaRepository<Clazz, Long>{

    @Query("SELECT DISTINCT c FROM Clazz c LEFT OUTER JOIN FETCH c.seminarTypes")
    List<Clazz> findAllWithSeminarType();

}
