package com.synergistic.policyms.service.member;

import com.synergistic.policyms.domain.Member;
import com.synergistic.policyms.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired private MemberRepository memberRepository;
    @Override
    public Member getMember(String memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(String memberId) {
        memberRepository.deleteById(memberId);
    }
}
