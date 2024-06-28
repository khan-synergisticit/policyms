package com.synergistic.policyms.service.healthPlan;

import com.synergistic.policyms.domain.HealthPlan;
import com.synergistic.policyms.domain.HealthPlanMetalLevel;
import com.synergistic.policyms.domain.PageInfo;
import com.synergistic.policyms.repository.HealthPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HealthPlanServiceImpl implements HealthPlanService {

    @Autowired private HealthPlanRepository healthPlanRepository;

    @Override
    public HealthPlan createHealthPlan(HealthPlan healthPlan) {
        return healthPlanRepository.save(healthPlan);
    }

    @Override
    public HealthPlan updateHealthPlan(HealthPlan healthPlan) {
        return healthPlanRepository.save(healthPlan);
    }

    @Override
    public void deleteHealthPlan(HealthPlan healthPlan) {
        healthPlanRepository.delete(healthPlan);
    }

    @Override
    public HealthPlan getHealthPlan(String healthPlanId) {
        return healthPlanRepository.findById(healthPlanId).orElse(null);
    }

    @Override
    public List<HealthPlan> getHealthPlans() {
        List<HealthPlan> healthPlans = healthPlanRepository.findAll();
        return healthPlans;
    }

    @Override
    public Page<HealthPlan> query(PageInfo pageInfo,  HealthPlanMetalLevel healthPlanMetalLevel, Integer age, Double healthPlanPremium, String coverage){
        Pageable pageable = PageRequest.of(pageInfo.getPageNo(), pageInfo.getPageSize(), pageInfo.getSortOrder().equalsIgnoreCase("asc") ? Sort.by(pageInfo.getSortBy()).ascending() : Sort.by(pageInfo.getSortBy()).descending());

        return healthPlanRepository.findDistinctByHealthPlanPremiumLessThanAndAgeAndHealthPlanMetalLevelAndHealthPlanCoverage(pageable, healthPlanPremium, age, healthPlanMetalLevel, coverage);
    }
}
