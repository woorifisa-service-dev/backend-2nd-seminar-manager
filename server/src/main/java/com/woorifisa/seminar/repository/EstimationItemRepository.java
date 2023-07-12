package com.woorifisa.seminar.repository;

import com.woorifisa.seminar.entity.EstimationItem;
import com.woorifisa.seminar.entity.constant.EvaluationArea;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimationItemRepository extends JpaRepository<EstimationItem, Long> {

    List<EstimationItem> findEstimationItemsByEvaluationAreaOrderByOrder(EvaluationArea evaluationArea);

    List<EstimationItem> findEstimationItemsByEvaluationAreaInOrderByOrder(List<EvaluationArea> evaluationAreas);

}
