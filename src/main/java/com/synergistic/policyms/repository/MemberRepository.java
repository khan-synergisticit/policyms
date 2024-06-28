package com.synergistic.policyms.repository;

import com.synergistic.policyms.domain.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
