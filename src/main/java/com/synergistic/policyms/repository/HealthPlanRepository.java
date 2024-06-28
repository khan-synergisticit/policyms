package com.synergistic.policyms.repository;

import com.synergistic.policyms.domain.HealthPlan;
import com.synergistic.policyms.domain.HealthPlanMetalLevel;
import com.synergistic.policyms.domain.HealthPlanType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HealthPlanRepository extends MongoRepository<HealthPlan, String> {
    Page<HealthPlan> findByHealthPlanTypeAndHealthPlanMetalLevelAndAge(Pageable pageable, HealthPlanType healthPlanType, HealthPlanMetalLevel healthPlanMetalLevel, Integer age, Double healthPlanPremium);
    Page<HealthPlan> findByAgeAndHealthPlanPremiumLessThan(Pageable pageable, Integer age, Double healthPlanPremium);
    Page<HealthPlan> findDistinctByHealthPlanPremiumLessThan(Double healthPlanPremium, Pageable pageable);
    Page<HealthPlan> findDistinctByHealthPlanPremiumLessThanAndAgeAndHealthPlanMetalLevelAndHealthPlanCoverage(Pageable pageable, Double premium, Integer age, HealthPlanMetalLevel healthPlanMetalLevel, String healthPlanCoverage);

}
