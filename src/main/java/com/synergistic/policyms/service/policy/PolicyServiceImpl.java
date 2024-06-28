package com.synergistic.policyms.service.policy;

import com.synergistic.policyms.domain.Policy;
import com.synergistic.policyms.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired private PolicyRepository policyRepository;
    @Override
    public Policy createPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public Policy updatePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public void deletePolicy(String policy) {
        policyRepository.deleteById(policy);
    }

    @Override
    public Policy getPolicy(String policyId) {
        return policyRepository.findById(policyId).orElse(new Policy());
    }

    @Override
    public List<Policy> findAllByPolicyId(List<String> policyIds) {
        List<Policy> policies = policyRepository.findAllByPolicyIdIsIn(policyIds);
        return policies;
    }

    @Override
    public List<Policy> findUnapprovedPolicies() {
        List<Policy> policies = policyRepository.findByIsApproved(false);
        return policies;
    }
}
