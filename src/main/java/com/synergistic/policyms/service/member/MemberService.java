package com.synergistic.policyms.service.member;

import com.synergistic.policyms.domain.Member;

public interface MemberService {
    Member getMember(String memberId);
    Member createMember(Member member);
    Member updateMember(Member member);
    void deleteMember(String memberId);
}
