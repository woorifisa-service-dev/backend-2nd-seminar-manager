package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.OtherEstimationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherEstimationItemRepository extends JpaRepository<OtherEstimationItem, OtherEstimationItem.Id> {
}
