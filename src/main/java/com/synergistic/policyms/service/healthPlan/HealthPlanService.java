package com.synergistic.policyms.service.healthPlan;

import com.synergistic.policyms.domain.HealthPlan;
import com.synergistic.policyms.domain.HealthPlanMetalLevel;
import com.synergistic.policyms.domain.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HealthPlanService {
    HealthPlan createHealthPlan(HealthPlan healthPlan);
    HealthPlan updateHealthPlan(HealthPlan healthPlan);
    void deleteHealthPlan(HealthPlan healthPlan);
    HealthPlan getHealthPlan(String healthPlanId);
    List<HealthPlan> getHealthPlans();
    Page<HealthPlan> query(PageInfo pageInfo, HealthPlanMetalLevel healthPlanMetalLevel, Integer age, Double healthPlanPremium, String coverage);

}
