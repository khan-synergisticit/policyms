package com.synergistic.policyms.service.policy;

import com.synergistic.policyms.domain.Policy;

import java.util.List;

public interface PolicyService {
    Policy createPolicy(Policy policy);
    Policy updatePolicy(Policy policy);
    void deletePolicy(String policyId);
    Policy getPolicy(String policyId);
    List<Policy> findAllByPolicyId(List<String> policyIds);
    List<Policy> findUnapprovedPolicies();
}
