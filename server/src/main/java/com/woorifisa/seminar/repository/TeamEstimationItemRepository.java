package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.TeamEstimationItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamEstimationItemRepository extends JpaRepository<TeamEstimationItem, TeamEstimationItem.Id> {
}
