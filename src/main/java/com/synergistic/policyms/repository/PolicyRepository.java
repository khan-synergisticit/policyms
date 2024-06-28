package com.synergistic.policyms.repository;

import com.synergistic.policyms.domain.Policy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PolicyRepository extends MongoRepository<Policy, String> {
    List<Policy> findByIsApproved(Boolean isApproved);
    List<Policy> findByPolicyId(String policyId);
    List<Policy> findAllByPolicyIdIsIn(List<String> policyIds);
}
